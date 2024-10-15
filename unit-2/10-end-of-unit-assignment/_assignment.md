In this assignment, you'll write a Java program to simulate an ecosystem containing two types of creatures, bears and fish. The ecosystem consists of a river, which is modeled as an array with 100 elements. Each cell of the array should contain an `Animal` object, which can be a `Bear` object, a `Fish` object, or `null`.

### `Animal` Class

Each `Animal` object should have instance variables to represent their **sex** (`boolean` value - `true` = female, `false` = male) and **strength**. Any necessary getter & setter methods should also be included.

A method `collide` should be created for when one `Animal` object collides with another `Animal` (more details on when this will happen are written below). There are 4 situations that can occur:

1.  The `Animal` objects have opposite sexes. In this situation, the method should return `"baby"`.
2.  The `Animal` objects have the same sex. The current object has higher strength than the other `Animal`. This object defeats its opponent and the method should return `"beat"`.
3.  The `Animal` objects have the same sex. The current object has lower strength than the other `Animal`. This object is defeated by its opponent and the method should return `"die"`.
4.  The `Animal` objects have the same sex. The current object has the same strength as the other `Animal`. Neither object defeats its opponent and the method should return `"bounce"`.

### `Fish` and `Bear` Classes

The `Fish` and `Bear` classes extend the `Animal` class and add no additional instance variables.

Both `Fish` and `Bear` should have a `toString` method that displays their information in the following format:

**`|<m/f><strength><B/F>|`**

For example:

A male fish with strength 4 would be displayed as `|m4F|`.

A female bear with strength 9 would be displayed as `|f9B|`.

Both classes should override the `collide` method from the `Animal` class to account for when they collide with an animal of the other species. If a `Bear` collides with a `Fish`, the method should return `"eat"`. If a `Fish` collides with a `Bear`, the method should return `"eaten"`. In any other scenario, the criteria listed in the `Animal` class should be followed.

**Hint: You should look up** `instanceOf` **to help with this!**

### Modeling the ecosystem

Upon the simulation starting, the ecosystem (a 100-element `Animal` array) should be populated with objects. Each element within the array should have a **10%** chance of being a `Fish`, a **5%** chance of being a `Bear`, and an **85%** chance of being empty initially. If a `Fish` or `Bear` is created, its sex should be randomly assigned with a 50% chance either way and its strength should be a random number between 1 and 9 (inclusive).

Your program should simulate **10** time cycles within the ecosystem. At each time step, each animal will randomly (a) move left in the array, (b) move right in the array, or (c) stay still. Each of these should be a ~33% chance. If a collision occurs between two objects, the `collide` method should be called between the objects. Depending on the result, the array should be adjusted accordingly.

- `"baby"` - A new object matching the type of the two colliding `Animals` should be created at a random empty position in the ecosystem.
- `"beat"` - The moving animal will replace the one it collided with.
- `"die"` - The moving animal is defeated by the one it collided with and is removed from the array.
- ` "bounce``" ` - Neither animal is defeated and neither moves
- `"eat"` - The bear eats the fish it encountered and replaces it in the array
- `"eaten"` - The fish is eaten by the bear it encountered and is removed from the array

For each situation, the two animals that collided and the result of the collision should be displayed like so (these are examples).

`|f4B| and |m9B| make a baby bear`

`|f6F| eaten by |m6B|`

Protections should be put in place to ensure that no animal acts more than once in a time cycle. One baby should also be the limit per pair of animals each time cycle.

At the beginning of the simulation and at the end of each time cycle, the river should be printed out. Any spaces that are empty should be represented with a `~`, and all non-empty spaces should be represented by their `toString` values. Below is an example of how the river might look:

`~|m5F|~~~~~~~|f4F|~~~|f9F||f9F|~~~~~~~~~~~~~~~~~|m3B|~...` (truncated for space)
