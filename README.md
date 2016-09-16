##Build status

Windows: [![Build status](https://ci.appveyor.com/api/projects/status/bwa9fdp3emb9ljk8/branch/master?svg=true)](https://ci.appveyor.com/project/mads256c/betterchat/branch/master)

Linux: ![Build Status](https://codeship.com/projects/dce43b80-5b42-0134-7628-4297ec814d8e/status?branch=master)


##Source installation information for modders 

This code follows the Minecraft Forge installation methodology. It will apply some small patches to the vanilla MCP source code, giving you and it access to some of the data and functions you need to build a successful mod.

Note also that the patches are built against "unrenamed" MCP source code (aka srgnames) - this means that you will not be able to read them directly against normal code.

##Gradlew build guide

To build this project open command prompt in the project root.
Type 'gradlew build' to build the project. You can find it in /build/libs/BetterChat-X.X

It has to pass the CodeShip build test before your pull request get merged.
