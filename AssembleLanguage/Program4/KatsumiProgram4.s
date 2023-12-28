# File name KatsumiProgram4.s
# CS 2640 Keita Katsumi
# Assignemnt 4
# Description
# 2D array, 5X3  initialze 10 and prompt menue, and accept integers from user
# Menu displays replace value, calculate total Sum, print 2D array, and Exit options
# When user inputs 4, the program exits
#
# Register Assignments
# $t0 = pointer to current beginning of row
# $t1 = Row counter and index
# $t2 = Colums counter and index
# $t3 = pointer to current address to store data
# $t4 = value to be stored to in each array element
# $t5 = offset of row
# $t6 = offset of column
#
# $s0 = terminate number
# $s1 = user menue choice  
# $s2 = user input row
# $s3 = user input column
# $t4 = user input replace value
# $s4 = store value from array
# $s5 = total sum of 2D array

				.data
ar2D: 		.space 60 						# Array of 15 integers(4 bytes each) in 5 X 3 array
trmNum:	.word 4 							# Meue 4 terminates the loop
menu:		.asciiz "\n\nMenu (Enter an integer as your choice):  "
fnct1: 		.asciiz "\n1) Replace a value"
fnct2: 		.asciiz "\n2) Calculate the sum of all values"
fnct3: 		.asciiz "\n3) Print out the 2D array"
fnct4: 		.asciiz "\n4) Exit"
prmp:		.asciiz "\nWhat would you like to do? \n\nYour choice: "
f1prmpR:.asciiz "\nWhich row would you want to access? (Note: Row 1 is [0]) : "
f1prmpC:.asciiz "\nWhich column you want to access? (Note: Column 1 is [0]) : "
f1prmpV:.asciiz "\nWhich value would you want to replace? : "
space:		.asciiz " "
nxtLn:		.asciiz "\n"
rslt:			.asciiz "\nTotal Sum: "


				.text 								# Program starts here
				.globl main 						# globally define 'main'
main:												# Initiailize 5X3 2D array filling up with 10	
				la $t0, ar2D					# Initialize pointer to start of array
				and $t1, $t1, $0 			# Initialize row counter / index
				# li $t4, 0x4ff6				# Put value to be loaded in array in $t4
				li $t4, 10						# Put value to be loaded in array in $t4
rloop:		and $t2, $t2, $0 			# Initialize column counter / index
				or $t3, $0, $t0				# Initialize col. pointer to 1st element of row
cloop: 		sw $t4, 0($t3)				# Store value in current array element
				addi $t2, $t2, 1 			# Increment column counter / index by 1
				beq $t2, 3, nxtrow 		# Go to next row if column counter = 3
				sll $0, $0, 0 					# no-op, delay
				addi $t3, $t3, 4 			# Increment the column pointer, access the next column index
				j cloop								# Go back and do another column
				sll $0, $0, 0 					# no-op, delay
nxtrow:	addi $t1, $t1, 1 			# Increment row counter / index by 1
				beq $t1, 5, loopmn 		# Leave row loop if row counter = 5
				add $t0, $t0, 12			# Increment the beginning-of-row pointer by
														#      the number of bytes in a row, 4 bytes * 3 colums = 12
    			j rloop								# Start new row
    			sll $0, $0, 0 					# no-op, delay

loopmn:	lw $s0, trmNum    			# Promp menu, and it repeats until user input 4
				la $a0, menu
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
				la $a0,  prmp
				li $v0, 4
				syscall
														# Accept integer from user
				li $v0, 5 							# syscall to accept integer from user
				syscall
				add $s1,  $v0, $0 			# Store user choice to $s1 							
				li $s2, 1
				beq $s1, $s2, ifOne 		# if user pick mecue 1
				sll $0, $0, 0 					# no-op, delay
				li $s2, 2
				beq $s1, $s2, ifTwo 		# if user pick mecue 2
				sll $0, $0, 0 					# no-op, delay				
				li $s2, 3
				beq $s1, $s2, ifThree 	# if user pick mecue 3
				sll $0, $0, 0 					# no-op, delay				
				bne $s0, $s1, loopmn 	# Check  user input 1,2,3 goes to brunch. if others back to loop
				sll $0, $0, 0 					# no-op, delay				
				j Exit								# Exit loop when user input 4
				sll $0, $0, 0 					# no-op, delay				
ifOne:												# Replace specified index of the 2D array with the user input value 			
				li $v0, 4 							# Accept row index from user
				la $a0, f1prmpR				
				syscall 							
				li $v0, 5 							
				syscall
				add $s2,  $v0, $0 				

				li $v0, 4 							# Accept column index from user
				la $a0, f1prmpC				
				syscall 							
				li $v0, 5 							
				syscall
				add $s3,  $v0, $0 				

				li $v0, 4 							# Accept replaceing value  from user
				la $a0, f1prmpV			
				syscall 							
				li $v0, 5 							
				syscall
				add $t4,  $v0, $0 			

				la $t0, ar2D					# Initialize pointer to start of array
				and $t1, $t1, $0 			# Initialize row counter / index
				or $t3, $0, $t0				# Initialize col. pointer to 1st element of row
				li $t5, 12 						# Prepare for row offset calculation
				mul $t5, $t5, $s2 			# 12 multiple user row input => row offset
				li $t6, 4 							# Prepare for column offset calculation
				mul $t6, $t6, $s3			# 4 multiple user culumn input => column offset
				add $t3, $t3, $t5			# Add row offser to current pointer
				add $t3, $t3, $t6			# Add column offser to current pointer
				sw $t4, 0($t3)				# Store user input value to indicated 2D arrray index 
				j loopmn
				sll $0, $0, 0 					# no-op, delay								

ifTwo:												# Total sum of all elements in 2D array		
				la $t0, ar2D					# Initialize pointer to start of array
				and $t1, $t1, $0 			# Initialize row counter / index
				and $s4, $s4, $0 			# Initialize $s4 for total sum
				and $s5, $s5, $0 			# Initialize $s5 for total sum
rlpSum:	and $t2, $t2, $0 			# Initialize column counter / index
				or $t3, $0, $t0				# Initialize col. pointer to 1st element of row
clpSum: 	lw $s4, 0($t3)				# Access current index and 
				add $s5, $s5, $s4 		# Increment column counter / index by 1
				addi $t2, $t2, 1 			# Increment column counter / index by 1
				beq $t2, 3, nxtrwS 		# Go to next row if column counter = 3
				sll $0, $0, 0 					# no-op, delay								
				addi $t3, $t3, 4 			# Increment the column pointer, access the next column index
				j clpSum								# Go back and do another column
				sll $0, $0, 0 					# no-op, delay								
nxtrwS:	addi $t1, $t1, 1 			# Increment row counter / index by 1
				beq $t1, 5,  printS 		# Leave row loop if row counter = 5
				sll $0, $0, 0 					# no-op, delay								
				add $t0, $t0, 12			# Increment the beginning-of-row pointer by
														#         the number of bytes in a row, 4 bytes * 3 colums = 12
    			j rlpSum							# Start new row
    			sll $0, $0, 0 					# no-op, delay								

printS:    	li $v0, 4 							# syscall to print string
				la $a0, rslt 						# Print result string
				syscall 							# print the 1st string promptf
				li $v0, 1 							# Display total Sum
				add $a0, $s5, $0 			# Store result of sum to a0      
				syscall
				la $a0, nxtLn 					# Change line to print result Sum clearly
    			li $v0, 4
    			syscall
    			j loopmn							# Back to menu
    			sll $0, $0, 0 					# no-op, delay								

ifThree:											# Total sum of all elements in 2D array		
				la $t0, ar2D					# Initialize pointer to start of array
				and $t1, $t1, $0 			# Initialize row counter / index
				la $a0, nxtLn 					# Change line to print first row clearly
    			li $v0, 4
    			syscall
rlpPrnt:	and $t2, $t2, $0 			# Initialize column counter / index
				or $t3, $0, $t0				# Initialize col. pointer to 1st element of row
clpPrnt: 	lw $s4, 0($t3)				# Access current index
				li $v0, 1 							# Display current array value
				add $a0, $s4, $0 			# Store result of sum to a0      
				syscall
				la $a0, space					# Print space
    			li $v0, 4
    			syscall
				addi $t2, $t2, 1 			# Increment column counter / index by 1
				beq $t2, 3, nxtrwP 		# Go to next row if column counter = 3
				sll $0, $0, 0 					# no-op, delay								
				addi $t3, $t3, 4 			# Increment the column pointer, access the next column index
				j clpPrnt							# Go back and do another column
				sll $0, $0, 0 					# no-op, delay								
nxtrwP:	la $a0, nxtLn 					# Change line to print next row
    			li $v0, 4
    			syscall
				addi $t1, $t1, 1 			# Increment row counter / index by 1
				beq $t1, 5, loopmn		# Leave row loop if row counter = 5
    			sll $0, $0, 0 					# no-op, delay								
				add $t0, $t0, 12			# Increment the beginning-of-row pointer by
														#         the number of bytes in a row, 4 bytes * 3 colums = 12
    			j rlpPrnt							# Start new row
    			sll $0, $0, 0 					# no-op, delay								

Exit:													# User input 4 
				li $v0, 10 						# Reach here if row loop is done
				syscall 							# End of program