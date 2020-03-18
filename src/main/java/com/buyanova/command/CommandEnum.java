package com.buyanova.command;

import com.buyanova.command.implementation.DOMParserCommand;
import com.buyanova.command.implementation.LocaleCommand;
import com.buyanova.command.implementation.SAXParserCommand;
import com.buyanova.command.implementation.StAXParserCommand;

public enum CommandEnum {

    DOM_PARSER(new DOMParserCommand()),
    SAX_PARSER(new SAXParserCommand()),
    STAX_PARSER(new StAXParserCommand()),
    LANGUAGE(new LocaleCommand());

    Command command;

    CommandEnum(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
