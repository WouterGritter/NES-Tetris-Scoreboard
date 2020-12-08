# ALPHABET
| Decimal | Hexadecimal | Letter |
|---------|-------------|--------|
|   00    |   `0x00`    |   0    |
|   01    |   `0x01`    |   1    |
|   02    |   `0x02`    |   2    |
|   03    |   `0x03`    |   3    |
|   04    |   `0x04`    |   4    |
|   05    |   `0x05`    |   5    |
|   06    |   `0x06`    |   6    |
|   07    |   `0x07`    |   7    |
|   08    |   `0x08`    |   8    |
|   09    |   `0x09`    |   9    |
|   10    |   `0x0A`    |   A    |
|   11    |   `0x0B`    |   B    |
|   12    |   `0x0C`    |   C    |
|   13    |   `0x0D`    |   D    |
|   14    |   `0x0E`    |   E    |
|   15    |   `0x0F`    |   F    |
|   16    |   `0x10`    |   G    |
|   17    |   `0x11`    |   H    |
|   18    |   `0x12`    |   I    |
|   19    |   `0x13`    |   J    |
|   20    |   `0x14`    |   K    |
|   21    |   `0x15`    |   L    |
|   22    |   `0x16`    |   M    |
|   23    |   `0x17`    |   N    |
|   24    |   `0x18`    |   O    |
|   25    |   `0x19`    |   P    |
|   26    |   `0x1A`    |   Q    |
|   27    |   `0x1B`    |   R    |
|   28    |   `0x1C`    |   S    |
|   29    |   `0x1D`    |   T    |
|   30    |   `0x1E`    |   U    |
|   31    |   `0x1F`    |   V    |
|   32    |   `0x20`    |   W    |
|   33    |   `0x21`    |   X    |
|   34    |   `0x22`    |   Y    |
|   35    |   `0x23`    |   Z    |
|   36    |   `0x24`    |   -    |
|   37    |   `0x25`    |   ,    |
|   79    |   `0x4F`    |   /    |
|   94    |   `0x5E`    |   (    |
|   95    |   `0x5F`    |   )    |
|   110   |   `0x6E`    |   "    |
|   111   |   `0x6F`    |   .    |
|   255   |   `0xFF`    |(space) |

# NAMES
Names are 6 bytes long and are saved as per the alphabet above ^.  

### Ranges
`0x50 - 0x55`: A pos 1 name  
`0x56 - 0x5B`: A pos 2 name  
`0x5C - 0x61`: A pos 3 name  

`0x68 - 0x6D`: B pos 1 name  
`0x6E - 0x73`: B pos 2 name  
`0x74 - 0x79`: B pos 3 name  



# SCORES
Scores are saved as a literal dec <> hex transformation.  
Examples:  
`0x01`: `01`  
`0x99`: `99`  
`0xAB`: `AB`  
`0xFF`: `FF`  

### Ranges
`0x00 - 0x02`: A pos 1 score  
`0x03 - 0x05`: A pos 2 score  
`0x06 - 0x08`: A pos 3 score  

`0x0C - 0x0E`: B pos 1 score  
`0x0F - 0x11`: B pos 2 score  
`0x12 - 0x14`: B pos 3 score  



# LEVELS
Levels are stored as the actual value.

### Ranges
`0x18`: A pos 1 level  
`0x19`: A pos 2 level  
`0x1A`: A pos 3 level  

`0x1C`: B pos 1 level  
`0x1D`: B pos 2 level  
`0x1E`: B pos 3 level  
