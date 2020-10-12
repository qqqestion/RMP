package com.emoji.projfinal.http;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandLineParser {
    public Map<String, String> arguments;

    public CommandLineParser() {
        this.arguments = new HashMap<>();
    }

    public void addArgument(String argName) {
        arguments.put(argName, null);
    }

    public void addArgument(String argName, String defaultValue) {
        arguments.put(argName, defaultValue);
    }

    public Map<String, String> parseArgs(String[] args) throws Exception {
        for (int i = 0; i < args.length; i += 2) {
            if (arguments.containsKey(args[i])) {
                arguments.put(args[i], args[i + 1]);
            }
        }
        if (arguments.containsValue(null)) {
            throw new Exception("Required argument wasn't provided");
        }

        return arguments;
    }
}
