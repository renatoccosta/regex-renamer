# Built-in Expressions #

Regex-renamer comes with the most used functions on the rename process already as a variable expression. The functions are:

  * **Case**: Changes the case of the body's content;
  * **Filter**: Filter some characters of the body's content;
  * **Index**: Generate a sequence of numbers for each file renamed;
  * **Replace**: Replace all occurrences of a character on the body's content for another;

## Case ##

Changes the case of the body's content to lower or upper case.

### Syntax ###

`${case[:upper|lower]}`

### Examples ###

`${case:upper}test${/case}` results in `TEST`

`${case:lower}TEST${/case}` results in `test`

## Filter ##

Filter some characters of the body's content. It's possible to remove letters, numbers, symbols or white-spaces.

### Syntax ###

`${filter[:l|n|s|w]}`

  * `l`: Filters out the letters
  * `n`: Filters out the numbers
  * `s`: Filters out the symbols (everything that are not letters and numbers)
  * `w`: Filters out the white-spaces

### Examples ###

`${filter:n}year2010${/filter}` results in `year`

`${filter:l}year2010${/filter}` results in `2010`

## Index ##

Generate a sequence of numbers for each file renamed. The sequence can have leading zeros and start from a certain number.

### Syntax ###

`${idx:cont:leadingZeros}`

  * `cont`: Is the number to start the sequence. If not specified, it will be 0.
  * `leadingZeros`: Number of leading zeros. If not specified, it will be 1.

### Examples ###

`${idx}` results in `0`, `1`, `2`, etc, depending on the number of files renamed.

`${idx:5}` result in `5`, `6`, `7`, etc, depending on the number of files renamed.

`${idx:8:2}` result in `08`, `09`, `10`, etc, depending on the number of files renamed.

## Replace ##

Replace all occurrences of a character on the body's content for another one. It's possible to replace more than one set of characters at once.

### Syntax ###

`${replace:s:r[:s:r]...}`

  * `s`: Character to be replaced
  * `r`: Replacement character

The `s:r` pair can be repeated to replace many characters at once.

### Examples ###

`${replace:e:3}renato${replace}` results in `r3nato`

`${replace:e:3:a:4:o:0}renato${replace}` results in `r3n4t0`