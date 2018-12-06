# INFO6205_111

A brute-force password cracking attack might well suss out a password like “Superman”, but it will fail to
guess in finite time when the password is something like jio9-md@5-7$ol-qma8. Using a random
password generator isn’t completely secure. Most of the random password generators use a
pseudo-random algorithm. In theory, a hacker who knows the algorithm and has access to one of the
previously generated passwords can predict all of the subsequent passwords (quite difficult). Our goal is
to build a password generator that doesn’t let anyone predict the future password even if they have
access to any previous randomly generated passwords.
