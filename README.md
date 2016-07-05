# react-native-native-env
React Native Native Environment module can provide environment variables from native to js

## Install
You can use [rnpm](https://github.com/rnpm/rnpm) to install native module easily;

```bash
npm install react-native-native-env --save
rnpm link
```

And in Android, you must change the line in MainActivity :

```java
new RCTNativeEnvPackage()
```

to

```java
new RCTNativeEnvPackage(BuildConfig.class)
```

## Usage
In js:
```javascript
import NativeEnv from 'react-native-native-env';

NativeEnv.get("APPLICATION_NAME"); // return application's name
NativeEnv.get("VERSION_NAME");// return application's version name
```
Yeah, we hava defined some native variables. These're:

|              Key | Source ( Android )                 | Source ( iOS )             |
|-----------------:|------------------------------------|----------------------------|
| APPLICATION_ID   | BuildConfig.APPLICATION_ID         | CFBundleIdentifier         |
| APPLICATION_NAME | PackageManager.getApplicationLabel | CFBundleName               |
| VERSION_CODE     | BuildConfig.VERSION_CODE           | CFBundleVersion            |
| VERSION_NAME     | BuildConfig.VERSION_NAME           | CFBundleShortVersionString |
| DEBUG            | BuildConfig.DEBUG                  | #ifdef DEBUG               |

Also, you can add some environment variables before react-native runtime is running.

###For Android
Your can send a Map when you init this Module:

```java
HashMap<String, Object> envs = new HashMap();
envs.put("testInfo", "this is a string");
envs.put("testNumber", 23333);
new RCTNativeEnvPackage(BuildConfig.class, envs);
```

And you can add variables from everywhere before it's inited:

```java
RCTNativeEnv.addEnv(key, value);
RCTNativeEnv.addEnvs(map);
```

###For iOS
Your can just add variables from everywhere before react runtime running.

```c
[LRDRCTNativeEnv addEnv:@"test" value:@"info"];
[LRDRCTNativeEnv addEnvs:@{@"testInfo":@"this is a string",@"testNumber":@23333}];
```