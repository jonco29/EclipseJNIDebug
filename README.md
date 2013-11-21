EclipseJNIDebug
===============

small repo with an eclipse JNI debugging.  Each commit is a new step in the process

Using the latest commit, you can debug JNI in eclipse.  Assuming everything is setup correctly,
load project, open the jni.c file and set a break point on the switch statement and do:
Project->debug as->android native application.  If you have any issues, look at the gotchas/issues for commit
3 below.



commit 1: -- initial eclipse project with a button.  doesn't do anything
commit 2: -- added a jni, but currently it compiles by hand 
commit 3: -- eclipse integration
             -- gotchas/issues:
                - project->Android Tools->Add Native Support
                    * NDK location not valid in preferences 
                        -- fix by 'Window->Preferences->Android->NDK', update location
                    * creates jni/<library name.cpp> -- already have a jni, so i merely deleted it

            -- Properties->Buildiers-> NDK Builder (added by me)
                - Add a 'New Program'
                - name something useful -- NDK builder
                - path to 'ndk-build' script

            -- AndroidManifest.xml changes
                - enable debug
                - change Use SDK to match your phone

            -- debug as Android Native Application, you get these errors:
                    [2013-11-21 09:48:12 - JniDebug] ActivityManager: Starting: Intent { act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] cmp=com.example.jnidebug/.MainActivity }
                    [2013-11-21 10:02:55 - JniDebug] Unknown Application ABI: 
                    [2013-11-21 10:02:55 - JniDebug] Android
                    [2013-11-21 10:02:55 - JniDebug] Unknown Application ABI: 
                    [2013-11-21 10:02:55 - JniDebug] NDK:
                    [2013-11-21 10:02:55 - JniDebug] Unknown Application ABI: 
                    [2013-11-21 10:02:55 - JniDebug] WARNING:
                    [2013-11-21 10:02:55 - JniDebug] Unknown Application ABI: 
                    [2013-11-21 10:02:55 - JniDebug] APP_PLATFORM
                    [2013-11-21 10:02:55 - JniDebug] Unknown Application ABI: 
                    [2013-11-21 10:02:55 - JniDebug] android-18
                    [2013-11-21 10:02:55 - JniDebug] Unknown Application ABI: 
                    [2013-11-21 10:02:55 - JniDebug] is
                    [2013-11-21 10:02:55 - JniDebug] Unknown Application ABI: 
                    [2013-11-21 10:02:55 - JniDebug] larger
                    [2013-11-21 10:02:55 - JniDebug] Unknown Application ABI: 
                    [2013-11-21 10:02:55 - JniDebug] than
                    [2013-11-21 10:02:55 - JniDebug] Unknown Application ABI: 
                    [2013-11-21 10:02:55 - JniDebug] android:minSdkVersion
                    [2013-11-21 10:02:55 - JniDebug] Unknown Application ABI: 
                    [2013-11-21 10:02:55 - JniDebug] 8
                    [2013-11-21 10:02:55 - JniDebug] Unknown Application ABI: 
                    [2013-11-21 10:02:55 - JniDebug] in
                    [2013-11-21 10:02:55 - JniDebug] Unknown Application ABI: 
                    [2013-11-21 10:02:55 - JniDebug] ./AndroidManifest.xml
                    [2013-11-21 10:02:55 - JniDebug] Unknown Application ABI: 
                    [2013-11-21 10:02:55 - JniDebug] 
                    [2013-11-21 10:02:55 - JniDebug] Unknown Application ABI: 
                    [2013-11-21 10:02:55 - JniDebug] 
                    [2013-11-21 10:02:55 - JniDebug] Unknown Application ABI: 
                    [2013-11-21 10:02:55 - JniDebug] 
                    [2013-11-21 10:02:55 - JniDebug] Unknown Application ABI: 
                    [2013-11-21 10:02:55 - JniDebug] 
                    armeabi
                    [2013-11-21 10:02:55 - JniDebug] Unable to detect application ABI's

                    ==> make sure your manifest versions match your phone:
                        [jc@jc-u13:JniDebug]$ adb shell getprop|grep build.version
                        [ro.build.version.codename]: [REL]
                        [ro.build.version.incremental]: [eng.jc.20131105.131621]
                        [ro.build.version.release]: [4.3]
                  ===>> [ro.build.version.sdk]: [18]        <<===== you need your min SDK to be this


