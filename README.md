# RevLocAcc_CTF
In the heart of Agra, a mysterious challenge awaits tech-savvy &amp; cybersecurity adventurers. An Android app has surfaced, filled with secrets that link the digital world to the city's fascinating history. To solve this puzzle, participants need to crack the app's code and follow a trail that leads to a hidden treasure—a historical wonder

# Capture The Flag (CTF) Challenge: RevLocAcc_CTF.apk

This repository provides a detailed walkthrough of the CTF challenge created by me involving the `RevLocAcc_CTF.apk` file. There are two methods to solve this challenge.

## Method 1: Using apktool

### Step 1: Decompiling the APK
Decompile the APK file using apktool with the following command:

```apktool d ./RevLocAcc_CTF.apk```

### Step 2: Analyzing the Assets Folder
Navigate to the `assets` folder which contains two files: `sensitive.db` and `AndroidManifest.xml`. The `AndroidManifest.xml` file contains coordinates. Perform Open Source Intelligence (OSINT) on these coordinates to get the location name.

### Step 3: Unlocking the Database
The location name "TajMahal" is the password to unlock the `sensitive.db` file.

### Step 4: Finding the Flag
After unlocking the database with the password "TajMahal", you'll find the flag. Congratulations!

## Method 2: Using a Rooted Device or Emulator

### Step 1: Installing the App
Install the app on a rooted device or an emulator.

### Step 2: Running adb shell
Run the following command in adb shell:

```run-as com.example.app```

### Step 3: Copying the Database
Copy the `sensitive.db` file created during the installation into your local system using the following command:

```adb pull /data/user/0/com.example.app/databases/sensitive.db D:\ctf```

### Step 4: Analyzing the Assets Folder
Just like in Method 1, the `assets` folder contains the `AndroidManifest.xml` file with coordinates. Perform OSINT on these coordinates to get the location name.

### Step 5: Unlocking the Database
Again, the location name "TajMahal" is the password to unlock the `sensitive.db` file.

### Step 6: Finding the Flag
After unlocking the database, you'll find the flag. Well done!
