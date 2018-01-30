# Minecraft CO-creative artificial intelligence Data gathering Mod
The aim of this mod will be to develop a system that gathers data about where people place blocks when creating houses or structures within the game Minecraft. This information will then be stored within an SQL Database. This information will then, hopefully be used to help train a DNN or any other NN to build an agent which will work alongside the player to create structures in the game.

# Research Journal

## 22/01/2018
![journal1](https://user-images.githubusercontent.com/10634519/35233447-1c3e13fe-ff96-11e7-9a5a-922f2e7b68c4.png)

![journal2](https://user-images.githubusercontent.com/10634519/35233543-583c6b1c-ff96-11e7-916c-5d4adbefce7c.png)

established modding client for Minecraft Using Minecraft Forge and Intellij
created Github repo for pipeline
Upcoming tasks custom Block configuration to gather data on position in world. possible check event systems

## 29/01/2018
<img width="1600" alt="29012018buildingtab" src="https://user-images.githubusercontent.com/10634519/35525983-041a827a-051e-11e8-879f-ccaa8ad37836.png">
<img width="1600" alt="29012018modcreated" src="https://user-images.githubusercontent.com/10634519/35526026-2b461a3a-051e-11e8-9686-68c53412fa77.png">
<img width="1600" alt="29012018modfoundmc" src="https://user-images.githubusercontent.com/10634519/35526032-2d936266-051e-11e8-8e38-90f3c8822b8f.png">

Not a huge ammount of progress towards data gathering moreso maintance and ensuring that the mod is setup correctly with the client and server side settings being the main focus. Along side this I have added a custom creative tab. I hadn't reallized in creative mode in minecraft provides unlimited building blocks. But I could add marker blocks which the agent could look out for such as end building this house block or something. 

## 30/01/2018

Aim today was to take a look at how the event system worked and to see whether or not i could get positional data and make things happen based on these events

<img width="1600" alt="300118dimondshovelevent" src="https://user-images.githubusercontent.com/10634519/35572075-bb270c60-05cb-11e8-8a6d-b934e7514a92.png">

This Image shows how on start I can add specific items to the players inventory before the client runs 

<img width="1600" alt="300118positionbasedevents" src="https://user-images.githubusercontent.com/10634519/35572083-beaea3a2-05cb-11e8-9afb-46e5eff2a372.png">

Dimond axes dropped by Mobs based on the mobs current position. Hopefully this means I can interact with the event system to gather positional data based on where the player places something. I think that I may need to add points of refrence for the building rather than just getting the world data ( I.E. a block in the middle of the house which I can measure the distance from where the player places blocks relative to its position. I think doing this will be important to ensure that the agent always has a centeral point to build around)
