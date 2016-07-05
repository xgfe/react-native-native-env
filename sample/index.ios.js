/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  NativeModules,
  View
} from 'react-native';
import NativeEnv from 'react-native-native-env';

class samples extends Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Sample for React Native Native Environment!
        </Text>
        <Text style={styles.instructions}>
          This is the name of native : "{NativeEnv.get("APPLICATION_NAME")}"
        </Text>
        <Text style={styles.instructions}>
          This is the version of native : "{NativeEnv.get("VERSION_NAME")}"
        </Text>
        <Text style={styles.instructions}>
          This is a info from native : "{NativeEnv.get("testInfo")}"
        </Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('samples', () => samples);
