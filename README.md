A text-based console application to perform simple natural language calculations which uses shunting yard algorithm
to perform operations
Supported Input Values
     The supported input values are the whole numbers between zero and ten inclusive.
     Input values must be expressed as text, e.g. ‘one’, ‘five’, etc
     Input values are not case-sensitive. Both ‘two and ‘TWO’ are equally valid.
Supported Arithmetic Operators
   Operator Permitted Aliases
          Add (+) add, plus
          Subtract (-) subtract, minus, less
          Multiply (*) multiplied-by, times
          Divide (/) divided-by, over
   Aliases are not case-sensitive. Both ‘add’ and ‘ADD’ are equally valid.
Operation Chaining
     Any number of operations may be chained together. For example, these calculations are
all valid
        o ‘one plus two’
        o ‘seven times eight minus nine’
        o ‘four times five subtract six over one plus nine’
Operator Precedence
    When two or more operations are chained together, any multiply or divide operation
must take precedence over any add or subtract operation, similar to how a real
calculator works.
