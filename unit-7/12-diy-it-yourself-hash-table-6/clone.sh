# fail script if any command fails
set -e
# take the current directory in format #-diy-it-yourself-hash-table-# and copy this directory $(pwd) to a new directory with the first number incremented by 2 and the second number incremented by 1
# Example: #-diy-it-yourself-hash-table-# -> (#+2)-diy-it-yourself-hash-table-(#+1)

# Get the current directory
current_dir=$(pwd)

# Get the current directory name
current_dir_name=$(basename $current_dir)

# Get the first number
first_number=$(echo $current_dir_name | grep -oP '\d+' | head -1)

# Get the second number
second_number=$(echo $current_dir_name | grep -oP '\d+' | tail -1)

# Increment the first number by 2
new_first_number=$((first_number + 2))

# Increment the second number by 1
new_second_number=$((second_number + 1))

# Create the new directory name
new_dir_name=$(echo $current_dir_name | sed "s/$first_number/$new_first_number/; s/$second_number/$new_second_number/")
new_dir_name=$(echo $new_dir_name | sed 's/-diy-it-yourself-hash-table-/-diy-it-yourself-hash-table-/')

# Create the new directory
new_dir=$(echo $current_dir | sed "s/$current_dir_name/$new_dir_name/")
cp -r $current_dir $new_dir
code $new_dir
echo "New directory created: $new_dir"
