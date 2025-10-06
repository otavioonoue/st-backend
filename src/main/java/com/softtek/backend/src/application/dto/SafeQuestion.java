package com.softtek.backend.src.application.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SafeQuestion {
    public String key;
    public String text;
    public Map<String, String> alternatives;
}
