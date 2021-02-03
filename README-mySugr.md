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

## Publishing

### Set-up key
1. Get the Android GPG key from 1Password and copy it to the folder
2. Fill out the needed properties in local-properties (can also be found in 1Password)
3. NEVER push anything of this
4. Now you are good to go

### Publish locally
1. Perform your changes
2. Run the `publishToMavenLocal` task

### Publish to the JFrog repository
To make your changes available for QA or release builds, they need to be published to the
JFrog repository.
1. Increase the version in build.gradle
1. Merge your changes to the mysugr-custom branch
1. Run the `bintrayUpload` task