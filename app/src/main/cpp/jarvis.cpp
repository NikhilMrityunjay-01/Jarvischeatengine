#include <jni.h>
#include <string>
#include "ESP.h"
#include "Hacks.h"
#include <iostream>

FILE *file;


ESP espOverlay;
int type=1,utype=2;
extern "C" JNIEXPORT void JNICALL
Java_com_tencent_qq_Overlay_DrawOn(JNIEnv *env, jclass , jobject espView, jobject canvas) {
    espOverlay = ESP(env, espView, canvas);

    if (espOverlay.isValid()){
        DrawESP(espOverlay, espOverlay.getWidth(), espOverlay.getHeight());
    }
}

extern "C" JNIEXPORT void JNICALL
Java_com_tencent_qq_Overlay_Close(JNIEnv *,  jobject ) {
    Close();
}

extern "C" JNIEXPORT void JNICALL
Java_com_tencent_qq_FloatLogo_SettingValue(JNIEnv *,  jobject ,jint code,jboolean jboolean1) {


    switch((int)code){


        case 1:
            isPlayerBox = jboolean1;   break;
        case 2:
            isPlayerLine = jboolean1;  break;
        case 3:
            isPlayerDist = jboolean1;  break;
        case 4:
            isPlayerHealth = jboolean1;  break;
        case 5:
            isPlayerName = jboolean1;  break;
        case 6:
            isPlayerHead = jboolean1;  break;
        case 7:
            isr360Alert = jboolean1;  break;
        case 8:
            isSkelton = jboolean1;  break;
        case 9:
            isGrenadeWarning = jboolean1;  break;
        case 10:
            isEnemyWeapon=jboolean1;  break;
        case 11:
            if(jboolean1 != 0)
                options.openState=0;
            else
                options.openState=-1;
            break;
        case 12:
            options.tracingStatus=jboolean1;
            break;
        case 14:
            options.pour=jboolean1;
            break;
        case 13:
            if(jboolean1 != 0)
                options.bulletTrack=0;
            else
                options.bulletTrack=-1;
            break;
        case 15:
            if(jboolean1 != 0)
                options.Hit=0;
            else
                options.Hit=-1;
            break;
        case 16:
            if(jboolean1 != 0)
                options.Crosshair=0;
            else
                options.Crosshair=-1;
            break;
        case 17:
            options.pour=jboolean1;
            break;
        case 18 :
            if(jboolean1 != 0)
                options.Hitx = 0;
            else
                options.Hitx=-1;
            break;
        case 19:

            break;
        case 20:

            break;
        case 21:
            if(jboolean1 !=0)
                options.Fasty= 0;
            else
                options.Fasty = -1;
        case 22:
            if(jboolean1 != 0)
                options.Recoil=0;
            else
                options.Recoil=-1;
            break;

    }
}

extern "C" JNIEXPORT void JNICALL
Java_com_tencent_qq_FloatLogo_Range(JNIEnv *,  jobject ,jint range) {
    options.aimingRange=1+range;
}
extern "C" JNIEXPORT void JNICALL
Java_com_tencent_qq_FloatLogo_Target(JNIEnv *,  jobject ,jint target) {
    options.aimbotmode=target;
}
extern "C" JNIEXPORT void JNICALL
Java_com_tencent_qq_FloatLogo_AimWhen(JNIEnv *,  jobject ,jint state) {
    options.aimingState=state;
}
extern "C" JNIEXPORT void JNICALL
Java_com_tencent_qq_FloatLogo_AimBy(JNIEnv *,  jobject ,jint aimby) {
    options.priority=aimby;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_com_tencent_qq_Overlay_getReady(JNIEnv *, jclass ,int typeofgame) {
    int sockCheck=1;
    if (!Create()) {
        perror("Creation failed");
        return false;
    }
    setsockopt(sock,SOL_SOCKET,SO_REUSEADDR,&sockCheck, sizeof(int));
    if (!Bind()) {
        perror("Bind failed");
        return false;
    }

    if (!Listen()) {
        perror("Listen failed");
        return false;
    }
    if (Accept()) {
        SetValue sv{};
        sv.mode=typeofgame;
        sv.type=utype;
        send((void*)&sv,sizeof(sv));
// Close();
        return true;
    }
}
