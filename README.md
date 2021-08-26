# Four in a row
Game made with testing in mind, due to being made in a unit testing oriented course.

Asks the users how many rounds they want to play and randomizes which player starts then asks them in what column they want to put their piece. After a minimum of seven rounds, the program starts to check if there is a player with four in a row. This is checked by looping through the first three columns or rows, then adding 1, 2 and 3 to the array to check if the symbol in those spots is the same. If it is, the method returns true which ends the round and awards a point to the winning player.

After a round ends, players get a prompt if they want to see a replay of the played round or not. The game then continues until one player wins best of the amount of rounds chosen at the start.

Made as part of my education.
