package com.conygre.spring.boot.service;

import com.conygre.spring.boot.entities.CompactDisc;

import java.util.List;

public interface CompactDiscService {
    List<CompactDisc> getCatalog();
}
