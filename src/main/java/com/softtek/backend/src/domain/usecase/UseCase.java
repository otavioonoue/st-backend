package com.softtek.backend.src.domain.usecase;

public interface UseCase<Input, Output> {
    Output execute(Input input);
}