# NotePad

NotePad is a simple android application that stores and displays notes created by a user.

It is to be built over the month of July, 2017. 

There are 4 main tasks listed as project 'issues'. Each of these are equivalent to a weekly 'sprint'. In which we'll work on building a component of the app together.

The merge process will be as such: 

  This will be Sprint 1 which will map to Issue 1 and so on. 

  This means that each of you should pull the project from the `develop` branch, create a local branch in the format of: 

    1-splash-yourname
    2-rv-yourname
    3-dialog-yourname
    4-db-yourname

Depending on what week we're in, and push that branch: `git push -u origin yourbranchname`, to the remote. Each student is to then make a pull request to `develop` and begin working on their local branch continually pushing to remote so that you update your pull request and others can comment on your code.


### Week 1: Splash screen. 

We'll begin in simplicity to get the hang of working together. This week we will establish a system that will set the pace for the next month. 

This week your branch name will be: `1-splash-yourname.`

* You are all to work on making this feature complete, this means that you will all branch away from develop with the appropriate branch name, push this branch to the repo, open a pull request for this feature and from your local copy, push to your remote continually. You will work collectively to complete it. During class time we will discuss different approaches and work to complete a version that all of us are okay with.

* You will measure yourself by talking through these pull requests and updating your branches accordingly. Copy pasting will do you a disservice, the point is to investigate approaches individually, ask each other questions and come up with an efficient solution.

* At the end of Sunday night of class that week, the feature should be complete and the introducion and discussion of the next component should take place.

* If you have any questions about the feature, this can be addressed as a comment on the relevant issue. 

#### Week 1: class 1 review:

* This first class we touched upon the import feature on android studio, we learned that when ever we need to import a project onto android studio we need to choose the folder that contains the gradle files at the root. In our case this is  in `NotePad/NotePad/`
* We also talked about different approaches when it comes to building features, ideally we want to build them correctly and the best way possible the first time arround, but a very real concern is that at work we will have deadlines to accomplish and we need to know how to make the best tradeoffs possible. In the github issue I denoted what would be the best way to build a splashscreen had we the time, but since we have only a month, we will instead try to build this using views. In the github issue I will have updated the task with how the splash screen should look, using custom views.
* During `Solve` we tried the "given a string, replace all the ' ' characters with '%20'" problem. We found out that there are a couple of different apporaches on solving this and left it open so that students would try to solve it in their own time. 

#### Week 1: class 2 review:

* no class

#### Week 2: class 1 review:

* In this class we reviewd object animators and  went over the different parts of a recyclerview touching on how they're put together.
  * The layout manager: A layout manager manages they way your layout is laid on the screen, either a grid, linerly or you can create your own custom one.
  * A View Holder: By subclassing the View Holder class, here you denileate how your individual item layouts will look like, you create an xml with your layout and inflate it in this class.
  * Adapter: Your adapter will adapt your data to your viewholders. This is done thorugh three methods, the `getItemCount()`, `onCreateViewHolder()` and `onBindViewHolder()` which are self explanatory names. 

* At the end of class we went over a shift matrix problem where the input was a String[] where n >= 1 and each item in the collection corresponds to dots and letters, ie: ".a.b." and a String with directions "LDRU". The objective of the problem was to parse this string given to us so that we would shift letters to "open":('.') spaces by replacing the dots with the letter correspoing in the proper direction.
    
#### Week 2: class 2 review:

* In this class we built out the basics of the recycler view, we also created a Floating action button with the intention of having a click listener on it that when clicked would add a new item to the recycler view.

#### Week 3: class 1 review:

* In this class we finished the last things needed for the implementation of the recyclerview and began work on the dialog fragment. 

* We learned that there are different ways to work with dialogs in android, we can create our own custom one, or use an alert dialog provided by the system. We can also create a fragment or a fragment dialog. 

#### Week 4: class 1 review:

* In this class we added the realm database to enable saving new notes, to allow them to be edited and to have them persist.
