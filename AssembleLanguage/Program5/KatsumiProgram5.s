# File name KatsumiProgram5.s
# Description: The program uses 3 subroutine
# 1. Accept from user and store Name, Age, and ID corresponding 10 index arrays
# 2. Print all the array element as a sinlge line
# 3.  Swap entry following user choice
# Last modified May 1st, 2023


# Issue
# The program accepts 10 names and newline when user input name
# It causies troube to display values in a sible line from 3 different arrays .
# Because string array contains \n

# Register List
# $t0 walker Index, counter
# $t1 loading address
# $t2 pointer, copy the starting address and calculate to access the value
# $t3 values from array
# $t4 Calculation actual first index = user input -1
# $t5 Calculate actual second index = user input -1 
# $t6 Second pointer 
# $t7 temporary value to prepare for swap
# $t8 display index: make sure array index = user input -1
# $t9 Checking condition in menu

# $s0 user input
# $s1 user menu choice
# $s2 user first index
# $s3 use second index
# $s4 Offset calculation: 4
# $s5 Offset Calculation
# $s6
# $s7 Offset Calculation

				.data
NmArr: 	.space 400 					# Array of 10 integers as Name
AgeArr: 	.space 40 						# Array of 10 integers as Age
IDArr: 		.space 40 						# Array of 10 integers as Age
inputSiz: 	.space 40    					# Reserve 40 bytes of memory for maximum 40 character
inputSiz2:.space 40    					# Reserve 40 bytes of memory for maximum 40 character
trmNum:	.word 2 							# Meue 4 terminates the loop
instrc:    	.asciiz "Enter in the name, age and ID for 10 students please:\n"
menu:		.asciiz "\n\nMenu (Enter an integer as your choice):  "
optn1: 	.asciiz "\n1) Swap two recordes."
optn2: 	.asciiz "\n2) Exit"
prmp:		.asciiz "\nPlease choose one of the above options: "
qstn1:		.asciiz "\nWhich record do you select first? (Note: Row 1 is [1]) : "
qstn2:		.asciiz "\nWhich record do you want to swap it with? (Note: Row 1 is [1]) : "
Rec: 		.asciiz "\nRecord "
clm: 		.asciiz ": "
space:		.asciiz "  "
nxtLn:		.asciiz "\n"


				.text 								# Program starts here
				.globl main 						# globally define 'main'
main:												# Initiailize Name, ID, and age 10 index arrays
				jal fllUp							# Call subroutine 1 to fill up 3 arrays, Name array, AgeArray, ID array
				sll $0, $0, 0 					# no-op, delay
				and $t0, $t0, $0 			# Initialize counter / index	
				jal prntAll						# Call subroutine 3 to print after swap
				sll $0, $0, 0 					# no-op, delay

lpMenu: 											# Promp menu, and it repeats until user input 2
				
				and $t0, $t0, $0 			# Initialize counter / index
				la $a0, menu					# Prompt menu
				li $v0, 4
				syscall
				la $a0, optn1					# Display choice
				li $v0, 4
				syscall
				la $a0, optn2					# Display choice
				li $v0, 4
				syscall
				la $a0, prmp					# Display prompt
				li $v0, 4
				syscall
														# Accept integer from user
				li $v0, 5 							# syscall to accept integer from user
				syscall
				add $s1,  $v0, $0 			# Store user choice to $s1
				li $t9, 1
				beq $s1, $t9, op1 		# Check  user input 1 or 2, user choose 1 and go to branch and call subroutine 1
				sll $0, $0, 0 					# no-op, delay
				li $t9, 2				
				beq $s1, $t9, Exit 	 	# Check  user input 1 or 2, user choose 2 and exit the program.
				sll $0, $0, 0 					# no-op, delay				
				j lpMenu							# Exit loop when user input 2
				sll $0, $0, 0 					# no-op, delay

op1:			 										# User choose 1, swap rows
				and $t0, $t0, $0 			# Initialize counter / index	
				la $a0, qstn1					# Display Question 1
				li $v0, 4
				syscall										
				li $v0, 5 							# Accept the first integer from user
				syscall
				add $s2, $v0, $0 			# Store user choice to $s2 	
				la $a0, qstn2					# Display Question2 
				li $v0, 4
				syscall		
				li $v0, 5 							# Accept the second integer from user
				syscall
				add $s3, $v0, $0 			# Store user choice to $s3 	

				and $t0, $t0, $0 			# Initialize counter / index	
				jal swap							# Call subroutine 2 to swap rows
				sll $0, $0, 0 					# no-op, delay
				
				and $t0, $t0, $0 			# Initialize counter / index	
				jal prntAll						# Call subroutine 3 to print after swap
				sll $0, $0, 0 					# no-op, delay
				
				j lpMenu							# Exit loop when user input 4
				sll $0, $0, 0 					# no-op, delay		

Exit:													# User input 2
				li $v0, 10 						# Reach here if row loop is done
				syscall 							# End of program




fllUp:												# Subroutine 1, Accepting name, age, id until  user inputs 10 times
				la $a0, instrc					# Display instruction
				li $v0, 4
				syscall		
				and $t0, $t0, $0 			# Initialize counter / index
				li $t4, 4 							# Prepare for offset calculation for age and ID
				li $s5, 40 						# Prepare for offset calculation for Name
AccLp:												# Accept name
				la $t1, NmArr					# Initialize pointer to start of array
				or $t2, $0, $t1				# Copy the original address, set up pointer
				mul $t5, $s5, $t0			# 4 multiple by counter  => pointer arithmetic
				add $t2, $t2, $t5			# Add offset to current pointer to reach array index
			    
		        li $v0,8 							# take in input, String name
		        la $a0, ($t2) 					# load byte space into address
		        li $a1, 40 						# allot the byte space for string
		        syscall

				la $t1, AgeArr				# Accept Age
			 	or $t2, $0, $t1				# Copy the original address Set up pointer
				li $v0, 5 						# Accept integer age from user
				syscall
				add $s0, $v0, $0 			# Store user input age to $s0 	
				mul $t5, $t4, $t0			# 4 multiple user input => pointer arithmetic
				add $t2, $t2, $t5			# Add offset to current pointer to reach array index
				sw $s0, 0($t2)				# Store age to age array

				la $t1, IDArr					# Accept ID
				or $t2, $0, $t1				# Copy the original address Set up pointer
				li $v0, 5 							# Accept integer ID from user
				syscall
				add $s0, $v0, $0 			# Store user input  ID  to $s0 	
				mul $t5, $t4, $t0			# 4 multiple user input => pointer arithmetic
				add $t2, $t2, $t5			# Add offset to current pointer to reach array index
				sw $s0, 0($t2)				# Store ID to ID array

				addi $t0, $t0, 1 			# Increment  the loop counter
				bne $t0, 10, 	AccLp 		# Check accept 10 names, ages, ids, if not back to loop
				sll $0, $0, $0
				jr $ra 								# Back to main after printing 10times
				sll $0, $0, 0 					# no-op, delay	


prntAll: 											# Subroutine 2, Print corresponding arrays  ndex and show them as a single line
				la $a0, Rec						# Print  "Record"
				li $v0, 4
				syscall
				addi $t8, $t0, 1 			# Calculate record number 
				li $v0, 1
				add $a0, $t8, $0 			# Store record number to a0     
				syscall
				la $a0, clm						# Print ": "
				li $v0, 4
				syscall
														# Print name
				la $t1, NmArr					# Initialize pointer to start of array
				or $t2, $0, $t1				# Copy the original address Set up pointer
				
				li $t4, 4 							# Prepare for offset calculation for age and ID
				li $s5, 40 						# Prepare for offset calculation for name
				mul $t5, $s5, $t0			# 40 multiple counter  => pointer arithmetic
				add $t2, $t2, $t5			# Add offset to current pointer to reach array index   
				la $a0, ($t2)					# Print name
				li $v0, 4 							
				syscall 
				la $a0, space					# Print "  "
				li $v0, 4
				syscall
														# Print Age
				la $t1, AgeArr				# Initialize pointer to start of array
				or $t2, $0, $t1				# Copy the original address Set up pointer
				li $t4, 4 							# Prepare for offset calculation
				mul $t5, $t4, $t0			# 4 multiple user input => pointer arithmetic
				add $t2, $t2, $t5			# Add offset to current pointer to reach array index
				lw $t3, 0($t2)				# Store Age to print out
				add $a0, $t3, $0 			# Store Age to a0      
				li $v0, 1 							# Print Age
				syscall 
				la $a0, space					# Print "  "
				li $v0, 4
				syscall
														# Print ID
				la $t1, IDArr					# Initialize pointer to start of array
				or $t2, $0, $t1				# Copy the original address Set up pointer
				li $t4, 4 							# Prepare for offset calculation
				mul $t5, $t4, $t0			# 4 multiple user input => pointer arithmetic
				add $t2, $t2, $t5			# Add offset to current pointer to reach array index
				lw $t3, 0($t2)				# Store ID to print out
				add $a0, $t3, $0 			# Store ID to a0      
				li $v0, 1 							# Print ID
				syscall 
				la $a0, space					# Print "  "
				li $v0, 4
				syscall

				addi $t0, $t0, 1 			# Increment  the loop counter
				bne $t0, 10, 	prntAll 	# Check accept 10 names
				sll $0, $0, $0
				jr $ra 								# Back to main after printing 10times
				sll $0, $0, 0 					# no-op, delay		


swap: 												# Subroutine 3, Swap Age	 												
				la $t1, NmArr					# Initialize pointer to start of array
				or $t2, $0, $t1				# Copy the original address Set up pointer
				or $t6, $0, $t1				# Copy the original address Set up pointer
				li $t4, 0							# Initilaize
				li $t5, 0							# Initialize
				and $t0, $t0, $0 			# Initialize counter / index
				addi, $t4, $s2, -1			# Calculate idex offset
				addi, $t5, $s3, -1			# Calculate idex offset
				li $s7, 40 						# Offset 	calculation
				mul $t4, $t4, $s7 			# Calculate offset 1
				sll $0, $0, 0 					# no-op, delay	
				mul $t5, $t5, $s7			# Calculate offset 2
				sll $0, $0, 0 					# no-op, delay	

				add $t2, $t2, $t4 			# Address of 1st user specified index
				add $t6, $t6, $t5			# Address of 2ns user specified index
				
				or $t3, $t2, $0
				la $t7, inputSiz 				# Load address for save word
			    li $t8, 0                			# initialize loop counter
cpy_lp:
			    lw $t9, ($t3)            		# load a word from the source address
			    sw $t9, ($t7)            		# store the word to the destination address
			    addi $t3, $t3, 4         	# increment the source address by 4 bytes
			    addi $t7, $t7, 4         	# increment the destination address by 4 bytes
			    addi $t8, $t8, 1         	# increment the loop counter
			    blt $t8, 10, cpy_lp 		# repeat until 8 words (40 bytes) are copied

			    la $t7, inputSiz 				# ?? Mysteriou line, if it is commented out swap doesn't work
				or $t1, $t6, $0
			    la $t3, inputSiz2
			    li $t8, 0                			# initialize loop counter
cpy_lp2:
			    lw $t9, ($t1)            		# load a word from the source address
			    sw $t9, ($t3)            		# store the word to the destination address
			    addi $t1, $t1, 4         	# increment the source address by 4 bytes
			    addi $t3, $t3, 4         	# increment the destination address by 4 bytes
			    addi $t8, $t8, 1         	# increment the loop counter
			    blt $t8, 10, cpy_lp2  	# repeat until 8 words (40 bytes) are copied

			    la $t3, inputSiz2 			# ?? Mysteriou line, if it is commented out swap doesn't work
			    li $t8, 0                			# initialize loop counter
store_lp:
			    lw $t9, ($t7)            		# load a word from the source address
			    sw $t9, ($t6)            		# store the word to the destination address
			    addi $t7, $t7, 4         	# increment the source address by 4 bytes
			    addi $t6, $t6, 4         	# increment the destination address by 4 bytes
			    addi $t8, $t8, 1         	# increment the loop counter
			    blt $t8, 10, store_lp  	# repeat until 8 words (32 bytes) are copied


			    li $t8, 0                			# initialize loop counter
store_lp2:
			    lw $t9, ($t3)            		# load a word from the source address
			    sw $t9, ($t2)           		# store the word to the destination address
			    addi $t3, $t3, 4         	# increment the source address by 4 bytes
			    addi $t2, $t2, 4         	# increment the destination address by 4 bytes
			    addi $t8, $t8, 1         	# increment the loop counter
			    blt $t8, 10, store_lp2	# repeat until 8 words (32 bytes) are copied


														# Swap Age												
				la $t1, AgeArr				# Initialize pointer to start of array
			 	or $t2, $0, $t1				# Copy the original address Set up pointer
				or $t6, $0, $t1				# Copy the original address Set up pointer
				and $t0, $t0, $0 			# Initialize counter / index
				addi, $t4, $s2, -1
				addi, $t5, $s3, -1
				mul $t4, $t4, 4 				# Calculate offset 1
				mul $t5, $t5, 4 				# Calculate offset 2
				add, $t2, $t2, $t4 		# Address of 1st user specified index
				add $t6, $t6, $t5			# Address of 2ns user specified index
				lw $t7, 0($t2) 				# temp = array[0], EX swap the first row and the last row
				lw $t3, 0($t6)				# temp2 = array[9]
				sw $t3, 0($t2)				# array[0] = temp2
				sw $t7, 0($t6)				# array[9] = temp

														# Swap ID												
				la $t1, IDArr					# Initialize pointer to start of array
				or $t2, $0, $t1				# Copy the original address Set up pointer
				or $t6, $0, $t1				# Copy the original address Set up pointer
				and $t0, $t0, $0 			# Initialize counter / index
				addi, $t4, $s2, -1
				addi, $t5, $s3, -1
				mul $t4, $t4, 4 				# Calculate offset 1
				mul $t5, $t5, 4 				# Calculate offset 2
				add, $t2, $t2, $t4 		# Address of 1st user specified index
				add $t6, $t6, $t5			# Address of 2ns user specified index
				lw $t7, 0($t2) 				# temp = array[0], EX swap the first row and the last row
				lw $t3, 0($t6)				# temp2 = array[9]
				sw $t3, 0($t2)				# array[0] = temp2
				sw $t7, 0($t6)				# array[9] = temp

				jr $ra 								# Back to main after printing 10 times
				sll $0, $0, 0 					# no-op, delay		






