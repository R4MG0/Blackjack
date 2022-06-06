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
