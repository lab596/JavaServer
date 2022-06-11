# 🖥 Java Server 🖥
This is a attempt to develop a personal java *http* server in order to run and manage web pages through my own personal computer.

The goal is develop an api between my computer *(to act as a server)* and an outside source to run commands in order to open webpages in the http and html format.

# 💪🏽 Motivation 💪🏽
I decided to take up this project for several reasons:
* Java Skillset
  - *I definately had a motivation for java programming so I thought that my experience could culminate in a real world application of what java is truly used for - back end development*
*  Privacy
   - *With growing concerns about privacy on public servers, I figured it would be worth to develop my own in order to protect my own personal information*

# 🔬 Resources 🔬
Intially my server is going to be greatly lead by tutorial videos as I hope to gain knowledge from these examples and eventually branch out into my own goals and modifications from what I hope to gain from a project such as this.

Currently most commits are lead by a tutorial by 🎬@CoderFromScratch🎬 and his Java Server tutorial series on youtube.

Additionlly packages used in this project are:
* Maven
   - *Tool that helps configure Java projects. It helps take care of files and helps work through the dependencies required for the project.* [Click here for more Info](https://www.simplilearn.com/tutorials/maven-tutorial/what-is-maven)

* Json 
   - *Javascript Object Notation. Manages client server relations and allows direct transfer of objects through server and client.* [Click here for more Info](https://www.youtube.com/watch?v=JuFdz8f-cT4)


# 🛠 Development 🛠
* I have currently connected the serverside and it is able to take input through a port and print out configuration. This has been implemented by http.json and is able to read the port and the temporary webroot provided there. (5/30/2022)
---
* I have allowed for the opening of a browser through a hard coded HTML website that simply displays that it has been opened using the server. Command *localhost:8080* is required in order to run through this port. The html is currently present in HttpServer.java in order to hard code but will be moved later. (5/31/2022)
---
* I have allowed for multithreading using the server by allowing for multiple connections to keep the port and server open. This keeps the program running in order to allow for multiple connections with the use of seperate computer threads. (6/1/2022)
---
* Started to develop a parser to read a legitimate input stream as opposed to the hardcoded website currently displayed. Must refrence official [RFC](https://datatracker.ietf.org/doc/html/rfc7230) to see where parsing information is provided and in what order. (6/2/2022)
---
* Started workeing on readers that allow for the grabing of the link in order to open a website. Also refrenced client and server errors and developed error messgaes to display in case any error took place. (6/11/22)

# 🪲 Bugs 🪲
* Maven Dependencies
  - One bug I kept running into was the dependencies in *pom.xml* would sometimes not find the groupid or artifactid I wanted to add. This resulted in a repetitive red coloration of the code simply saying it was unable to locate dependency. Despite my efforts to get the dependency from the [MVNrepo website](https://mvnrepository.com/) I continued to encounter this problem.
  - **Solution**: The only way I could solve this problem was by refreshing or cleaning the *pom.xml* file. One easy way to do this in *intellij* is by:
      - left clicking *pom.xml* --> hovering over "Maven" (second to last option for me) --> clicking "Reload project" (first option for me)
