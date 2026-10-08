# Value Statistics

A Java console application that uses a `while` loop to read five
floating-point values from the user, then reports the total, average,
maximum, minimum, and the interest on the total at 20%.

## Files

| File | Description |
|------|-------------|
| `pseudocode.txt` | Pseudocode design for the program |
| `ValueStatistics.java` | Java source code |
| `README.md` | This file |

## Compile

```
javac ValueStatistics.java
```

## Run

```
java ValueStatistics
```

## Preventing an Endless Loop

The program guards against an endless loop in two separate ways:

1. **Discarding bad input.** If the user types something that is not a
   number, `Scanner.nextDouble()` leaves that text in the input buffer.
   A loop that simply retried would read the same text forever. The
   program calls `next()` to throw the bad token away before looping.
2. **An attempt ceiling.** The loop condition also tests
   `attempts < MAX_ATTEMPTS`. Even if something unexpected happened,
   the loop cannot run more than ten times.

## Concepts Demonstrated

- `while` loop with a compound exit condition
- Input validation with `Scanner.hasNextDouble()`
- Running total, maximum, and minimum without an array
- Formatted output with `System.out.printf()`
