**GT-Helper**

**First Android app - interacts with Google Translate**

This application guides the user how to use Google Translate's camera, to
translate text from Hebrew to Polish, in order to read aloud the Polish text.

This process was done, because reading aloud Hebrew text is not supported in GT.

The application was tested on Samsung Galaxy A70 device (resolution of
1080\*2400).

**First screen:** The user is directed, vocally, to press the orange button
twice;

this results in launching Google Translate app and showing GT's camera.

![C:\\Users\\user\\Downloads\\Screenshot_20190909-150315_FirstButtonApp.jpg](media/aac21a3d327d929a84d92b3b640863cf.jpg)

**Second screen:**

The user has to press the black button twice;

This results in going back to GT's camera and pressing "Scan" button.

This reflects the recent changes done in Google Translate, summer 2019.

![C:\\Users\\user\\Downloads\\Screenshot_20190909-150544_FirstButtonApp.jpg](media/10ecbbafc6ba81c20fc47c101933cdbf.jpg)

Now, the user is being vocally directed with further instructions, which are
being performed right after pressing "Scan" button. These are:

"Press the circle to scan" and then "Press the white ellipse".

After these instructions, the user is redirected to the next screen.

**Third screen:** A green strip is presented on this screen;

the user has to press this strip twice, to go to GT's translation screen:

![C:\\Users\\user\\Downloads\\Screenshot_20190909-150805_FirstButtonApp.jpg](media/0fe959ed9b31308527b51accac89c1c0.jpg)

**Fourth screen:** after taking the photo with GT's camera and going to
translation,

we now have a blank screen. On this screen, the user has to swipe up using
finger.

![C:\\Users\\user\\Downloads\\Screenshot_20190909-151204_FirstButtonApp.jpg](media/ef0169a9983e8fef31ee3a5a46845d08.jpg)

**Fifth screen:** The user has to press the red button;

This results in copying the translated text from GT, to the clipboard.

Now, the user will hear the translated text read aloud, in Polish.

![C:\\Users\\user\\Downloads\\Screenshot_20190909-151343_FirstButtonApp.jpg](media/9ea4e603145a4cb4bf54db925aacec17.jpg)

**Code:**

**MainActivity.java:** Launches Google Translate app, right before the first
screen.

<https://github.com/LiorBob/GT-Helper-Samsung-Galaxy-A70/blob/master/src/main/java/com/example/user/firstbuttonapp/MainActivity.java>

**FirstActivity.java:** First screen: shows the orange button and handles its
click event.

<https://github.com/LiorBob/GT-Helper-Samsung-Galaxy-A70/blob/master/src/main/java/com/example/user/firstbuttonapp/FirstActivity.java>

**SecondActivity.java:** Second screen: shows the black button, handles its
click event and reads aloud further instructions, for pressing the circle and
white ellipse in GT.

<https://github.com/LiorBob/GT-Helper-Samsung-Galaxy-A70/blob/master/src/main/java/com/example/user/firstbuttonapp/SecondActivity.java>

**SecondActivityWithStrip.java:** Third screen: shows the green strip and
handles its click event.

<https://github.com/LiorBob/GT-Helper-Samsung-Galaxy-A70/blob/master/src/main/java/com/example/user/firstbuttonapp/SecondActivityWithStrip.java>

**ThirdActivity.java:** Fourth screen: shows the blank screen - directs user to
swipe up.

<https://github.com/LiorBob/GT-Helper-Samsung-Galaxy-A70/blob/master/src/main/java/com/example/user/firstbuttonapp/ThirdActivity.java>

**FourthActivity.java:** The fifth screen: shows the red button and handles its
click event;

If the user succeeds in all steps so far, this activity will read aloud the
translated text, in Polish.

<https://github.com/LiorBob/GT-Helper-Samsung-Galaxy-A70/blob/master/src/main/java/com/example/user/firstbuttonapp/FourthActivity.java>

**FifthActivity.java:** Shows a blank screen, for swipe down event.

(This and the next activity deal with optional steps, if the user wants to go
back to the beginning, to start all over again with new photo and translation)

<https://github.com/LiorBob/GT-Helper-Samsung-Galaxy-A70/blob/master/src/main/java/com/example/user/firstbuttonapp/FifthActivity.java>

**SixthActivity.java:** Shows a blue button and handles its click event, to
clear the previous translation, so we can go back to start all over again.

<https://github.com/LiorBob/GT-Helper-Samsung-Galaxy-A70/blob/master/src/main/java/com/example/user/firstbuttonapp/SixthActivity.java>

**OnSwipeTouchListener.java:** A class for the swipe up gesture. Found on the
net, used by ThirdActivity.java and FifthActivity.java above.

<https://github.com/LiorBob/GT-Helper-Samsung-Galaxy-A70/blob/master/src/main/java/com/example/user/firstbuttonapp/OnSwipeTouchListener.java>

**YouTube demo:**

<http://www.youtube.com/watch?v=m95zzZv7wgQ>
