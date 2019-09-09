# mySugr customizations

In order to fulfil specific needs of the mySugr app which is dealing
with blood glucose and related data we need to be able to color-code
line drawing and have custom and more versatile markers.

- Custom target range background
- Ability to stop scrolling deceleration from outside
- New scatter shape INVISIBLE + rendering
- Custom padding and positioning of bottom limit line
- Custom shape size and drawable
- Color-coded line renderer depending on target range and hyper/hypo

## Development

For development you should use Maven local, which means, that you deploy
to the local cache and your app picks up the local version instead of
trying to get the artifacts from a remote repository like jCenter. That
way you can conveniently do work on the library which is thereafter
quickly accessible on your app's side.

**On the library side:**

1. Perform your changes
1. Run the `publishToMavenLocal` task

**On the app side:**

1. On the *first time* Android Studio needs to know the new location of
   the local artifacts, so clean the dependencies cache (use File /
   Invalidate Caches / Restart" in Android studio
1. Once Android Studio knows, you can just use File / Sync with file
   system each time you used `publishToMavenLocal` (it works in an
   instant)

## Publishing

When you've done your work and want to publish your artifacts to the
public repository you have to push your changes to Bintray. To do that
just use the `bintrayUpload` task. Make sure you created the version
you intend to publish on Bintray!