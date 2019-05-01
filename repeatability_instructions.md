# Repeatability Instructions

<hr>

## Description of Project

PLATO stands for "Purification of Lousy Arguments Testing Onslaught". What this means for its services, is that it is a tool used to simulate SQL Injection Attacks against a web page and determining weaknesses arising from a lack of sanitation for inputs supplied by forms and delivered to the database for the system.

If a particular web page is prone to SQL Injection Attacks, then attacks to their system can cause data loss, data corruption, or denial of service. Without the proper protection, these attacks can cause severe damage to the database not just temporarily, but even long term, leading to a complete shutdown for a service for an indeterminate amount of time.

With proper sanitation of input from users, web pages are able to protect their database from potentially harmful users. Our system seeks to be an aid in this problem domain for web developers, providing a platform to attack their own system and be able to monitor what potential attackers are able to do from the user's public interface.

## Software Requirements

If you are interested in being able to utilize this project all you need for the chrome extension feature is simply the chrome browser.

<hr>

If you are interested in using the java-based browser portion of the project, we suggest you don't. It fails to support HTML5 and its features and is not feature complete in the slightest. If you really want to however, all you will need is Java installed on your computre and access to the IDE for ease of opening up the project and running/compiling it.

## Tool/Project Installation Instructions

To be able to add this beauty of a project into your chrome browser's extension suite, go to your chrome settings. From here, in the upper left corner, click the menu side bar labeled settings and access the extensions submenu. In this menu, activate developer mode in the upper right.

Once activated, you should see three options appear "Load Unpacked", "Pack Extension", "Update". Use the Load Unpacked setting here. A popup of your file system should appear. You will want to download our repo and select the "Joys of Painting" folder within the file structure. This file contains all of the necessary data for the chrome extension and will then we automatically added and accessible from your chrome's extension sidebar.

<hr>

If you'd like to use our browser, consider not doing so. The code for such is outdated and does not support the use of HTML5 or any of its features. If you'd like to attempt to install it any way, it is accessible as an Ecclipse project. Opening up ecclipse and importing the project is really all there is to it. From there run the launcher java file within Ecclipse and the browser should spin up on our example website for use.

## Instructions for Generating Results

The chrome extension's use is fairly simple post-installation. Simply click on the extension and begin filling out any necessary information. We are currently working on minimizing the amount of pilot work necessary in using the extension, so it should only get even more simple to test against SQL injection attacks on a browser.

<hr>

For using the browser portion of the project, running the java project from ecclipse will open up a rudimentary broswer window with a sidebar suite of attack methonds. Highlight your input and submit buttons in the form using the drop down arrows and fill out any of the attack forms to form an attack against the website.

## Folder Contents (main files, figures, videos etc.)

Directory Structure

 -- Documentation
 
 -- Java Web Browser
 
    -- res
    
    -- src
    
 -- Scraper
    
 -- Joy of Painting
 
    -- css
    
    -- js
    
    -- res
    
    -- manifest.json
    
    -- popup.html
    
### Documentation

Folder for the presentation and proposal document for the project

### Java Web Browser

Folder for our Java Web Browser Ecclipse project

#### Java Web Browser - res

Various resources for the Java Web Browser

#### Java Web Browser - src

Source code for the Java Web Browser

### Scraper

A website scraper that is used by the web browser to retrieve website data. Has been moved into the Java Web Browser tools package now

### Joy of Painting

This is the code for the chrome extension portion of the project

#### Joy of Painting - css

The css files for the general style of the popup

#### Joy of Painting - js

The javascript files for the dynamic handling of the popup

#### Joy of Painting - res

Some resources for the popup window

#### Joy of Painting - manifest.json

A file containing package information for the chrome extension

#### Joy of Painting - popup.html

The actual "web app" code proper for the extension
