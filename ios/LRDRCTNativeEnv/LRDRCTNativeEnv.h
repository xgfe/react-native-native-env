//
//  LRDRCTNativeEnv.h
//  LRDRCTNativeEnv
//
//  Created by luoruidong on 16/7/4.
//  Copyright © 2016年 remobile. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <React/RCTBridgeModule.h>

@interface LRDRCTNativeEnv : NSObject <RCTBridgeModule>
+ (void) addEnv:(NSString*)key value:(id)value;
+ (void) addEnvs:(NSDictionary*)info;
@end
