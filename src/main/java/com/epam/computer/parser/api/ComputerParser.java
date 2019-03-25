package com.epam.computer.parser.api;

import com.epam.computer.entity.Computer;

import java.util.List;

public interface ComputerParser {
    List<Computer> parse(String path);
}
