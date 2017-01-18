Test - Scala testing functionality
==================================
Scala testing functionality for general use (originally written for Registered Traveller UK).

Project built with the following (main) technologies:

- Scala

- SBT

- Specs2

- Scalatest

Introduction
------------
Keep your module's test dependencies consistent and up to date, and access to useful test functionality. 

Build and Deploy
----------------
The project is built with SBT. On a Mac (sorry everyone else) do:
```
brew install sbt
```

It is also a good idea to install Typesafe Activator (which sits on top of SBT) for when you need to create new projects - it also has some SBT extras, so running an application with Activator instead of SBT can be useful. On Mac do:
```
brew install typesafe-activator
```

To compile:
```
sbt compile
```

or
```
activator compile
```

To run the specs:
```
sbt test
```

To run integration specs:
```
sbt it:test
```

SBT - Revolver (keep things going while developing/testing)
-----------------------------------------------------------
sbt-revolver is a plugin for SBT enabling a super-fast development turnaround for your Scala applications:

See https://github.com/spray/sbt-revolver

For development, you can use ~re-start to go into "triggered restart" mode.
Your application starts up and SBT watches for changes in your source (or resource) files.
If a change is detected SBT recompiles the required classes and sbt-revolver automatically restarts your application. 
When you press &lt;ENTER&gt; SBT leaves "triggered restart" and returns to the normal prompt keeping your application running.

Releasing
---------
Version control of this library can be achieved through the SBT Release plugin e.g.
```
sbt release
```

where the following default value will be chosen:
- Continue with snapshots dependencies: no
- Release Version: current version without the qualifier (eg. 1.2.0-SNAPSHOT -> 1.2.0)
- Next Version: increase the minor version segment of the current version and set the qualifier to '-SNAPSHOT' (eg. 1.2.1-SNAPSHOT -> 1.3.0-SNAPSHOT)
- VCS tag: abort if the tag already exists
- VCS push:
    - Abort if no remote tracking branch is set up.
    - Abort if remote tracking branch cannot be checked (eg. via git fetch).
    - Abort if the remote tracking branch has unmerged commits.
    - Set release version and next version as command arguments

You can set the release version using the argument release-version and next version with next-version.

Example (within sbt):
```
release release-version 1.0.99 next-version 1.2.0-SNAPSHOT
```