package br.ufc.labinfo.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel Júnior
 */

public interface Command {
    public void execute(HttpServletRequest request,
                        HttpServletResponse response);
}
