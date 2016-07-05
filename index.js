import {NativeModules, Platform} from 'react-native';

let RCTNativeEnv = Platform.OS === 'android' ? NativeModules.NativeEnvironment : NativeModules.LRDRCTNativeEnv;
//first try to get infos from constants to get base info
let infos = RCTNativeEnv;
//then update it from get all
RCTNativeEnv.getAll(function(info){
  infos = info;
});

let NativeEnv = {
  get: function (key) {
    return infos[key];
  }
};

export default NativeEnv;
