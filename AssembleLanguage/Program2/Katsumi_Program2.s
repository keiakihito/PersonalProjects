				.data
prmp1: 	.asciiz "Please enter an integer : "
prmp2: 	.asciiz "\nPlease enter another integer : "
prmp3: 	.asciiz "\nThe average of your numbers is :  "
DVSR: 		.word 5 # Divisor for the average caluration

				.text # Program starts here
				.globl main # globally define 'main'
main:		# Accept 5 integers from user


				# 1st user input
				li $v0, 4 # syscall to print string
				la $a0, prmp1 # Store string value to address of the string
				syscall # print the 1st string prompt

				li $v0, 5 # syscall to accept integer from user
				syscall # Accept integer from user
				add $t1, $v0, $0  # Save user input to t1



				# 2nd user input
				li $v0, 4 # syscall to print string
				la $a0, prmp2 # Store string value to address of the string
				syscall # print the 2nd string prompt

				li $v0, 5 # syscall to accept integer from user
				syscall # Accept integer from user
				add $t2, $v0, $0  # Save user input to t2



				# 3rd user input
				li $v0, 4 # syscall to print string
				la $a0, prmp2 # Store string value to address of the string
				syscall # print the 2nd string prompt

				li $v0, 5 # syscall to accept integer from user
				syscall # Accept integer from user
				add $t3, $v0, $0  # Save user input to t3



				# 4th  user input
				li $v0, 4 # syscall to print string
				la $a0, prmp2 # Store string value to address of the string
				syscall # print the 2nd string prompt

				li $v0, 5 # syscall to accept integer from user
				syscall # Accept integer from user
				move $t4, $v0  # Save user input to t4



				# 5th user input
				li $v0, 4 # syscall to print string
				la $a0, prmp2 # Store string value to address of the string
				syscall # print the 2nd string prompt

				li $v0, 5 # syscall to accept integer from user
				syscall # Accept integer from user
				move $t5, $v0  # Save user input to t1



				# Sum up all the user input, s1 is for total  sum, s2 for divisor
				add $s1, $s1, $t1
				add $s1, $s1, $t2
				add $s1, $s1, $t3
				add $s1, $s1, $t4
				add $s1, $s1, $t5
				lw $s2, DVSR
				div $s1,  $s2 # Divide total b divisor
				mflo $s3 # quotient to $s3
				mfhi $s4 # remainder to $s4



				# Display result
				li $v0, 4 # syscall to print string
				la $a0, prmp3 # Store string value to address of the string
				syscall # print the 1st string promptf

				li $v0, 1
				add $a0, $s3, $0 # Store calculation result to a0      
				syscall


				# End program
				li $v0, 10 # syscall to exit cleanly from main only
				syscall # this ends execution
				.end  




				; # For debug Print t1
				; li $v0, 1
				; add $a0, $t1, $0
				; syscall










