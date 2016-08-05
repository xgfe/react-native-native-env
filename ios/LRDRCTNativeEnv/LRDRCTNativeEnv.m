//
//  LRDRCTNativeEnv.m
//  LRDRCTNativeEnv
//
//  Created by luoruidong on 16/7/4.
//  Copyright © 2016年 remobile. All rights reserved.
//

#import "LRDRCTNativeEnv.h"

static NSMutableDictionary *infos;

@implementation LRDRCTNativeEnv

+ (void)initialize {
    if (self == [LRDRCTNativeEnv class]) {
        infos = [[NSMutableDictionary alloc] init];
        NSDictionary *env = [[NSProcessInfo processInfo] environment];
        [infos addEntriesFromDictionary:env];
        [infos setObject:[[NSBundle mainBundle] objectForInfoDictionaryKey: @"CFBundleIdentifier"] forKey:@"APPLICATION_ID"];
        [infos setObject:[[NSBundle mainBundle] objectForInfoDictionaryKey: @"CFBundleName"] forKey:@"APPLICATION_NAME"];
        [infos setObject:[[NSBundle mainBundle] objectForInfoDictionaryKey: @"CFBundleVersion"] forKey:@"VERSION_CODE"];
        [infos setObject:[[NSBundle mainBundle] objectForInfoDictionaryKey: @"CFBundleShortVersionString"] forKey:@"VERSION_NAME"];
#ifdef DEBUG
        [infos setObject:@YES forKey:@"DEBUG"];
#else
        [infos setObject:@NO forKey:@"DEBUG"];
#endif
    }
}

+ (void) addEnv:(NSString*)key value:(id)value {
    [infos setObject:value forKey:key];
}
+ (void) addEnvs:(NSDictionary*)info {
    [infos addEntriesFromDictionary:info];
}

RCT_EXPORT_MODULE()

- (NSDictionary *)constantsToExport {
    return infos;
}

RCT_EXPORT_METHOD(get:(NSString *)key callback:(RCTResponseSenderBlock)callback {
    callback(@[infos[key]?infos[key]:[NSNull null]]);
});

RCT_EXPORT_METHOD(getAll:(RCTResponseSenderBlock)callback {
    callback(@[infos]);
});

@end
