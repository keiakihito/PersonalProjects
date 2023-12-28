		.data
greeting: .asciiz	"Hello world" 
name: .asciiz "\nMy name is Keita Katsumi, and my favorites are bellow;"
fGame: .asciiz	"\nGame: Chrono Triger."
fFilm: .asciiz	"\nMovie: Suzume."
fSong: .asciiz	"\nSong: Ain't no mountain high ennough."
artist: .asciiz	"\nPerformed by: Marvin Gaye & Tammi Terrell."

		.text
main: 	li $v0, 4 # Assign register print string system call
			la $a0, greeting # Assign value to the address of string
			syscall # print greeting

			li $v0, 4 # Assign register print string system call
			la $a0, name # Assign value to the address of string
			syscall  # print name

			li $v0, 4 # Assign register print string system call
			la $a0, fGame # Assign value to the address of string
			syscall  # print fgame

			li $v0, 4 # Assign register print string system call
			la $a0, fFilm # Assign value to the address of string
			syscall  # print fFilm

			li $v0, 4 # Assign register print string system call
			la $a0, fSong # Assign value to the address of string
			syscall  # print fSong

			li $v0, 4 # Assign register print string system call
			la $a0, artist  # Assign value to the address of string
			syscall  # print artist

			li $v0, 10 # Assign register end of programsystem call
			syscall # end program
			.end # end program