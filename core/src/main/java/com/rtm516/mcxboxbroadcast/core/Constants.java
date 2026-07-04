package com.rtm516.mcxboxbroadcast.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodec;
import org.cloudburstmc.protocol.bedrock.codec.v1001.Bedrock_v1001;

import java.net.URI;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class Constants {
    public static final Gson GSON = new GsonBuilder()
        .registerTypeAdapter(Instant.class, new InstantConverter())
        .registerTypeAdapter(Date.class, new DateConverter())
        .disableHtmlEscaping()
        .create();

    public static final String SERVICE_CONFIG_ID = "4fc10100-5f7a-4470-899b-280835760c07"; // The service config ID for Minecraft
    public static final String TEMPLATE_NAME = "MinecraftLobby";
    public static final String TITLE_ID = "896928775"; // The title ID for Minecraft Windows Edition
    public static final String CREATE_SESSION = "https://sessiondirectory.xboxlive.com/serviceconfigs/" + SERVICE_CONFIG_ID + "/sessionTemplates/" + TEMPLATE_NAME + "/sessions/%s";
    public static final String JOIN_SESSION = "https://sessiondirectory.xboxlive.com/handles/%s/session";

    public static final URI RTA_WEBSOCKET = URI.create("wss://rta.xboxlive.com/connect");
    public static final URI CREATE_HANDLE = URI.create("https://sessiondirectory.xboxlive.com/handles");

    public static final String PEOPLE = "https://social.xboxlive.com/users/me/people/xuid(%s)";
    public static final String USER_PRESENCE = "https://userpresence.xboxlive.com/users/xuid(%s)/devices/current/titles/current";
    public static final URI FOLLOWERS = URI.create("https://peoplehub.xboxlive.com/users/me/people/followers");
    public static final URI SOCIAL = URI.create("https://peoplehub.xboxlive.com/users/me/people/social");
    public static final URI SOCIAL_SUMMARY = URI.create("https://social.xboxlive.com/users/me/summary");
    public static final String FOLLOWER = "https://social.xboxlive.com/users/me/people/follower/xuid(%s)";

    public static final String GALLERY = "https://persona.franchise.minecraft-services.net/api/v1.0/gallery";

    public static final Duration WEBSOCKET_CONNECTION_TIMEOUT = Duration.ofSeconds(10);

    /**
     * https://github.com/LiteLDev/LeviLamina/blob/main/src/mc/network/ConnectionType.h
     */
    public static final int ConnectionTypeJsonRpc = 7;

    /**
     * Used to be 1000, but the limit was increased in Aug 2024
     */
    public static final int MAX_FRIENDS = 2000;

    public static final BedrockCodec BEDROCK_CODEC = Bedrock_v1001.CODEC;

    /**
     * Config version for upgrade purposes
     */
    public static final int CONFIG_VERSION = 2;
}
