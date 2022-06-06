# Blackjack

## Abstract 

The game is a blackjack game which Simeon, Marco and Kimi programmed with Java and the help of JavaFx for the GUI.

The goal of the project was to make multiple Card games,
so we started with blackjack.

Later we realized that the time was running out, so we decided to only make the blackjack game,
but to make this game final and to make this the best we can make it.

## How to run our code?

If you want to run our code, you can go to the Deployments Tab and
under the Releases Tab you are able to download the .jar file which you are able to run from your commandline with the following command.

Make sure that java is installed otherwise you won't be able to use this command. 

```bash
java -jar PATH_TO_YOUR_JAR_FILE.jar
```

Then you should be able to start the blackjack game by clicking on the diamond ace.

Be patient, it can take several seconds for the game to load all the ressources, when it's loaded,
the screen will show up and you will be able to play the game, just make a bet.
It should also be quite fast now because all the ressources are already loaded and don't get loaded again.

Sometimes there is a problem with the memory usage while starting the game (clicking on the ace). 
You recognize this when some text shows up in the commandline you started the game in.
It should be fixed by now but sometime it does happen. In this case you need to start the Jar file with allocating more memory.
You can do this with the following command:

```bash
java -Xmx4096m -jar PATH_TO_YOUR_JAR_FILE.jar
```

We were already able to run it with just 2Gb of memory.
So if you are really low on memory you could replace the attribute `-Xmx4096m` with `-Xmx2048m`.
But on most machines you don't even need to do this.

## Test Cases

Source version v1.0.0
Java Runtime version 8 Update 311.
And with openjdk version 17.0.1.

We didn't test anything with the library JUnit. We just tested with Users, because its a game,
which has some randomness involved (shuffling the stack).

But if we would test to do so, we would try to make a dealer
(player with the rules, which a dealer has) play against another dealer.

We tested our game on Windows and on Linux, since Marco and Simeon used Windows,
and Kimi was using Linux -> Arch btw.

| TestID | Preparations                                       | Description                                                                                              | Expected result                                                                                                                                                       |
|--------|----------------------------------------------------|----------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| T-01   | Game started                                       | If the user clicks on the diamond-ace, he will be redirected to the blackjack-game                       | Scene changes to the "blackjacktable", where the user can play blackjack.                                                                                             |
| T-02   | Blackjack must be selected                         | If the user enters an amount and presses the "Set" button, the amount will be set and cards get revealed | The amount entered will be set, and will be doubled and returned if the user wins, aswell as the cards get revealed to the user.                                      |
| T-03   | Bet placed                                         | If the user clicks on the "Hit" button, he will get another card                                         | Another card gets in the userhand and the user still can hit or hold.                                                                                                 |
| T-04   | User doesn't wanna hit anymore                     | If the user clicks on the "Hold" button, the dealer makes his turn                                       | Dealer does his turn, winner gets calculated, if the user wins, he gets his bet and winnings, else he loses his bet.                                                  |
| T-05   | 2 times the same card and didn't hit yet           | If the user uses the "Split" button, the user will get the second hand cards after holding.              | The user will get another hand of cards, after he holded with the first one and he plays with both hands against the dealer. The winners of both games get announced. |
| T-06   | hasn't hit yet                                     | If the user clicks on the "Double" button, he will get a card and pays his bet again                     | Bet gets doubled, the user gets another card. If the user wins, the winnings will be doubled too.                                                                     |
| T-07   | internet connection is active, in blackjackscene   | The user can get help from the web, through clicking on the "Help" button                                | The user will get a browsertab, which contain the rules of blackjack, and how he should play.                                                                         |

| TestID | Successful | Comments                                         |
|--------|------------|--------------------------------------------------|
| T-01   | Yes        | You have to wait a few seconds, but it works.    |
| T-02   | Yes        | Works perfectly fine.                            |
| T-03   | Yes        | Must be pressed if the user doesnt press double. |
| T-04   | Yes        | It works.                                        |
| T-05   | Yes        | I got the right output.                          |
| T-06   | Yes        | Works like it's intended to do.                  |
| T-07   | Yes        | Works great.                                     |

## Conclusion

Fortunately, we were able to deliver our project even though we had to narrow it down to just a blackjack on time. We
were able to distribute the tasks evently (Kimi = allrounder, Simeon = backend, Marco = frontend).
With this distribution we were able to move forward very efficiently and well because everyone
could work where he was assigned to and we just had to communicate when we had to combine the frontend with the backend.
If someone had a question, we first asked each other in our group.
If we had no idea at all how to solve the problem, we asked our coach.

We are also very satisfied with our program
and were able to do everything we wanted to do in our game.