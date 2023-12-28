				.data
intArr: 	.space 40 # int[] Array = new int [10];
ttlNum: 	.word 10 # Total number of intersters from user
trmNum:	.word 4 # Meue 4 terminates the loop

prmp1: 	.asciiz "Please enter 10 integer values: "
prmp2: 	.asciiz "\nYou intered these integers :  "
prmp3: 	.asciiz "\nCurrent integers : "
comma: 	.asciiz ", "
menu1: 	.asciiz "\n\nMenu (enter an int as your choice):  "
fnct1: 		.asciiz "\n1) Replace an element at a certain position"
fnct2: 		.asciiz "\n2) Remove the max element"
fnct3: 		.asciiz "\n3) Remove the min element"
fnct4: 		.asciiz "\n4) Compute values and exit"
munu2: 	.asciiz "\nWhat would you like to do?\n\nYour choice : "

opt1: 		.asciiz "\nChoice 1) replaceElement() is called."
opt2: 		.asciiz "\nChoice 2) eremoveMax() is called."
opt3: 		.asciiz "\nChoice 3) removeMin()is called."
opt4: 		.asciiz "\nChoice 4) Compute values is called."
opt1Str: .asciiz "\n\nWhat position from the array do you wish to replace? "
opt1Prm:.asciiz "\nWhat value to you want to change it to? "
opt4S: 	.asciiz "\nThe summation of all values in the array is: "
opt4P: 	.asciiz ", \nthe product of all values in the array is: "
extStr: 	.asciiz "\nprogram exit safely."


				.text # Program starts here
				.globl main # globally define 'main'
main:		# Prompt to accept 10 integers from user
				li $t0, 0 # Index 0 when it accepts user input
				lw $s0, ttlNum # loop counter, lw (load word) loads a word from memory to the $s0 register, ttlNum can be how many integer it will get and loop counter  
				and $s1, $s1, $0 # initialize 0 $s1 aka temp sum
				li $s2, 1 # initialize 1 $s2 aka temp product

				
loopAcc:	# Accept integers 10 times with loop
				li $v0, 4 # syscall to print string
				la $a0, prmp1 # Store string value to address of the string
				syscall # print prompt to enter 10 integers value
				li $v0, 5 # syscall to accept integer from user
				syscall # Accept integer from user
				sw $v0, intArr($t0) # Store user input to temporary register  				
				addi $t0, $t0, 4 # increment to the next address, pointer arithmetic
				addi $s0, $s0, -1 # decrement the loop counter
				bne $0, $s0, loopAcc # if loop counter equals to 0, exit loop otherwise back to loop: 

				# Display user inputs
				li $v0, 4 # syscall to print string
				la $a0, prmp2 # Store string value to address of the string
				syscall # print prompt to enter 10 integers value
				lw $s0, ttlNum # initialize number of elements as a loop counter 
				li $t0, 0 # Index 0 when it accepts user input

loopPrt: 	li $v0, 1
				lw $t1, intArr($t0)
				add $a0, $t1, $0
			   	syscall
			   	
			   	la $a0, comma # Print comma
    			li $v0, 4
    			syscall
			   	
			   	addi $t0, $t0, 4 # increment to the next address, pointer arithmetic
				addi $s0, $s0, -1 # decrement the loop counter
				bne $0, $s0, loopPrt # if loop counter equals to 0, exit loop otherwise back to loop: 

				# Display menu
loopmn:	lw $s4, trmNum # User choose mesue 4 and exits the loop
			 	la $a0,  menu1
				li $v0, 4
				syscall
				la $a0,  fnct1
				li $v0, 4
				syscall
				la $a0,  fnct2
				li $v0, 4
				syscall
				la $a0,  fnct3
				li $v0, 4
				syscall
				la $a0,  fnct4
				li $v0, 4
				syscall
				la $a0,  munu2
				li $v0, 4
				syscall


				li $v0, 5 # syscall to accept integer from user
				syscall # Accept integer from user
				add $t2,  $v0, $0 # Store user choice to $t2
				li $t3, 1
				beq $t2, $t3, ifOne # if user pick mecue 1
				li $t3, 2
				beq $t2, $t3, ifTwo # if user pick mecue 2
				li $t3, 3
				beq $t2, $t3, ifThree # if user pick mecue 3
				bne $s4, $t2, loopmn # Check  user input 1,2,3 goes to brunch. if others back to loop
				j Exit # get out loop when user input 4

				# Branches menu 1, 2 and 3
ifOne: 		la $a0,  opt1 # method 1 is called
				li $v0, 4
				syscall

				# Initialize registers
				lw $s0, ttlNum # store current arrray size
				li $t0, 0 # initialize Index 0 array index
				li $t2,0 # Store user input integer
				li $t7, 4 # Using for index calculation

				la $a0,  opt1Str # Prompt for user input index
				li $v0, 4
				syscall
				li $v0, 5 # syscall to accept integer from user
				syscall # Accept integer from user
				addi $t0, $v0, -1 # Assume user doesn't know satrt with 0 for counting
				mul	$t0, $t0, $t7 # user input idex - 1 * 4 is actual index to replace
				la $a0,  opt1Prm # Prompt for user input number
				li $v0, 4
				syscall
				li $v0, 5 # syscall to accept integer from user
				syscall # Accept integer from user
				add $t2, $v0 , $0 # store user input integer to $t2
				sw $t2, intArr($t0) # intArr[index] = userInput, replace specified index with user input integer

				# Display user inputs
				lw $s0, ttlNum # initialize number of elements as a loop counter 
				li $t0, 0 # Index 0 when it accepts user input
				# Display array and the check current integer in the array
				li $v0, 4 # syscall to print string
				la $a0, prmp3 # Store string value to address of the string
				syscall # print prompt to enter 10 integers value
loopPrt1:	li $v0, 1
				lw $t1, intArr($t0)
				add $a0, $t1, $0
			   	syscall		   	
			   	la $a0, comma # Print comma
    			li $v0, 4
    			syscall
			   	addi $t0, $t0, 4 # increment to the next address, pointer arithmetic
				addi $s0, $s0, -1 # decrement the loop counter
				bne $0, $s0, loopPrt1 # if loop counter equals to 0, exit loop otherwise back to loop: 

				j loopmn # Back to loop 

				# Option 2
ifTwo: 		la $a0,  opt2 # method 2 is called
				li $v0, 4
				syscall

				# Initialize registers
				lw $s0, ttlNum # store current arrray size
				li $t0, 0 # initialize Index 0 
				li $t2,0 # Store array elements
				li $t3, 0 # Temporary max
				li $t5, 0 # Max integer index
				lw $t6, ttlNum # Number of elements to pointer arithmetic
				addi $t6, $t6, -1 # offset
				li $t7, 0 # To get the last index of array
				# iterate array to find max 
loopMax:	lw  $t2, intArr($t0)     # load the current array element
    			bgt  $t2, $t3, fndMax # if the current element is greater than the current max, go to setmax
    			addi  $t0, $t0, 4    # increment $t0 to point to the next element in the array
				addi $s0, $s0, -1 # decrement the loop counter
				bne $0, $s0, loopMax # if loop counter equals to 0, exit loop otherwise back to loop: 
    			j       lpMxExt            # if $t0 is zero, we're done
fndMax:  or    $t3, $t2, $0        # set $t3 to the current max
				add $t5, $t0, $0 # Save max array index
    			addi    $t0, $t0, 4    # increment $t0 to point to the next element in the array
    			addi $s0, $s0, -1 # decrement the loop counter
				bne $0, $s0, loopMax # if loop counter equals to 0, exit loop otherwise back to loop: 
    			j       lpMxExt            # if $t0 is zero, we're done
    			# Display current integers in the array
lpMxExt:	mul $t7, $t6, 4 # Calculate last index of the array
				lw $t2, intArr($t7) # Get last index of array
				sw $t2, intArr($t5) # Replace max integer index with the last integer in the array
				lw $s0, ttlNum # store current arrray size
				addi $s0, $s0, -1 # Decrement array size
				sw $s0, ttlNum # Update current array element
				
				# Display user inputs
				lw $s0, ttlNum # initialize number of elements as a loop counter 
				li $t0, 0 # Index 0 when it accepts user input

				li $v0, 4 # syscall to print string
				la $a0, prmp3 # Store string value to address of the string
				syscall # print prompt to enter 10 integers value
loopPrt2:	li $v0, 1
				lw $t1, intArr($t0)
				add $a0, $t1, $0
			   	syscall
			   	
			   	la $a0, comma # Print comma
    			li $v0, 4
    			syscall
			   	
			   	addi $t0, $t0, 4 # increment to the next address, pointer arithmetic
				addi $s0, $s0, -1 # decrement the loop counter
				bne $0, $s0, loopPrt2 # if loop counter equals to 0, exit loop otherwise back to loop: 

				j loopmn # Back to loop 

				# Option 3
ifThree: 	la $a0,  opt3 # method 3 is called
				li $v0, 4
				syscall
				# Initialize regisers
				lw $s0, ttlNum # store current arrray size
				li $t0, 0 # initialize Index 0 
				li $t2,0 # Store array elements
				lw  $t3, intArr($t0) # Temporary min
				li $t5, 0 # Min integer index
				lw $t6, ttlNum # Number of elements to pointer arithmetic
				addi $t6, $t6, -1 # offset
				li $t7, 0 # To get the last index of array
loopMin:	lw  $t2, intArr($t0)     # load the current array element
    			ble  $t2, $t3, fndMin # if the current element is smaller  than the current max, go to setmax
    			addi  $t0, $t0, 4    # increment $t0 to point to the next element in the array
				addi $s0, $s0, -1 # decrement the loop counter
				bne $0, $s0, loopMin # if loop counter equals to 0, exit loop otherwise back to loop: 
    			j       lpMinExt            # if $t0 is zero, we're done
fndMin:  	or $t3, $t2, $0        # set $t3 to the current min
				add $t5, $t0, $0 # Save current min  array index
    			addi $t0, $t0, 4    # increment $t0 to point to the next element in the array
    			addi $s0, $s0, -1 # decrement the loop counter
				bne $0, $s0, loopMin # if loop counter equals to 0, exit loop otherwise back to loop: 
    			j       lpMinExt            # if $t0 is zero, we're done
lpMinExt:	mul $t7, $t6, 4 # Calculate last index of the array
				lw $t2, intArr($t7) # Get last index of array
				sw $t2, intArr($t5) # Replace max integer index with the last integer in the array
				lw $s0, ttlNum # store current arrray size
				addi $s0, $s0, -1 # Decrement array size
				sw $s0, ttlNum # Update current array element
				
				# Display current array 
				lw $s0, ttlNum # initialize number of elements as a loop counter 
				li $t0, 0 # Index 0 when it accepts user input
				li $v0, 4 # syscall to print string
				la $a0, prmp3 # Store string value to address of the string
				syscall # print prompt to enter 10 integers value
loopPrt3:li $v0, 1
				lw $t1, intArr($t0)
				add $a0, $t1, $0
			   	syscall	   	
			   	la $a0, comma # Print comma
    			li $v0, 4
    			syscall
			   	addi $t0, $t0, 4 # increment to the next address, pointer arithmetic
				addi $s0, $s0, -1 # decrement the loop counter
				bne $0, $s0, loopPrt3 # if loop counter equals to 0, exit loop otherwise back to loop: 
				j loopmn # Back to loop 

				# Option 4
Exit:			lw $s0, ttlNum # initialize loop counter to calculate total sum and product later
				li $t0, 0 # Index 0 when it accepts user input

				# Calculate  Total sum and Total product
loopRslt: 	li $v0, 1 # This is menu 4
				lw $t1, intArr($t0)
				add $s1, $s1, $t1
				mul $s2, $s2, $t1
			   	addi $t0, $t0, 4 # increment to the next address, pointer arithmetic
				addi $s0, $s0, -1 # decrement the loop counter
				bne $0, $s0, loopRslt # if loop counter equals to 0, exit loop otherwise back to loop: 

				# Display total sum and total product
				li $v0, 4 # syscall to print string
				la $a0, opt4 # Store string value to address of the string
				syscall # print the 1st string promptf

				li $v0, 4 # syscall to print string
				la $a0, opt4S # Store string value to address of the string
				syscall # print the 1st string promptf

				li $v0, 1
				add $a0, $s1, $0 # Store result of sum to a0      
				syscall

				li $v0, 4 # syscall to print string
				la $a0, opt4P # Store string value to address of the string
				syscall # print the 1st string promptf

				li $v0, 1
				add $a0, $s2, $0 # Store result of product to a0      
				syscall

				li $v0, 4 # syscall to print string
				la $a0, extStr # Store string value to address of the string
				syscall # print the 1st string promptf

				# End program
				li $v0, 10 # syscall to exit cleanly from main only
				syscall # this ends execution
				.end  



			















