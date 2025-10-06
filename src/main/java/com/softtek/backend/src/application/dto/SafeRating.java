package com.softtek.backend.src.application.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SafeRating {
    public String id;
    public String name;
    public Map<String, SafeQuestion> questions;
}
