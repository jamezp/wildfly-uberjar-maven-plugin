/*
Copyright 2020 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package org.wildfly.uberjar.runtime._private;

import java.nio.file.Path;

import org.jboss.logging.BasicLogger;
import org.jboss.logging.annotations.Cause;
import org.jboss.logging.annotations.MessageLogger;
import org.jboss.logging.Logger;
import static org.jboss.logging.Logger.Level.DEBUG;
import static org.jboss.logging.Logger.Level.INFO;
import static org.jboss.logging.Logger.Level.WARN;
import org.jboss.logging.annotations.LogMessage;
import org.jboss.logging.annotations.Message;

/**
 *
 * @author jdenise
 */
@MessageLogger(projectCode = "WFLYUJAR", length = 4)
public interface UberJarLogger extends BasicLogger {

    /**
     * Default root logger with category of the package name.
     */
    UberJarLogger ROOT_LOGGER = Logger.getMessageLogger(UberJarLogger.class, "org.wildfly.uberjar");

    @LogMessage(level = DEBUG)
    @Message(id = 1, value = "Shutting down")
    void shuttingDown();

    @LogMessage(level = DEBUG)
    @Message(id = 2, value = "Server stopped, exiting")
    void serverStopped();

    @LogMessage(level = DEBUG)
    @Message(id = 3, value = "Server not yet stopped, waiting")
    void serverNotStopped();

    @LogMessage(level = DEBUG)
    @Message(id = 4, value = "Null controller client, exiting")
    void nullController();

    @Message(id = 5, value = "Unexpected exception while shutting down server")
    RuntimeException unexpectedExceptionWhileShuttingDown(@Cause Throwable cause);

    @LogMessage(level = INFO)
    @Message(id = 6, value = "Installed %s in server deployments")
    void installDeployment(Path dep);

    @LogMessage(level = INFO)
    @Message(id = 7, value = "Installed server and application in %s, took %sms")
    void advertiseInstall(Path home, long duration);

    @LogMessage(level = WARN)
    @Message(id = 8, value = "Can't restart server, already shutdown")
    void allreadyShutdown();

    @LogMessage(level = DEBUG)
    @Message(id = 9, value = "Deleting %s dir")
    void deletingHome(Path dep);

    @LogMessage(level = WARN)
    @Message(id = 10, value = "Server tmp directory %s has not been deleted.")
    void homeNotDeleted(Path dep);

    @LogMessage(level = DEBUG)
    @Message(id = 11, value = "Deleting marker dir %s")
    void deletingMarkerDir(Path dep);

    @Message(id = Message.NONE, value = "Sets the start mode of the server, it can be either 'normal','admin-only' or 'suspend'. If this is 'suspend' the server will start in suspended mode, and will not service requests until it has been resumed. If this is started in admin-only mode the server will only open administrative interfaces and accept management requests but not start other runtime services or accept end user requests.")
    String argStartMode();

    @Message(id = Message.NONE, value = "Set system property jboss.bind.address to the given value")
    String argPublicBindAddress();

    @Message(id = Message.NONE, value = "Set system property jboss.bind.address.<interface> to the given value")
    String argInterfaceBindAddress();

    @Message(id = Message.NONE, value = "Set a system property")
    String argSystem();

    @Message(id = Message.NONE, value = "Display this message and exit")
    String argHelp();

    @Message(id = Message.NONE, value = "Load system properties from the given url")
    String argProperties();

    @Message(id = Message.NONE, value = "Set system property jboss.default.multicast.address to the given value")
    String argDefaultMulticastAddress();

    @Message(id = Message.NONE, value = "Print version and exit")
    String argVersion();

    @Message(id = Message.NONE, value = "Set a security property")
    String argSecurityProperty();

    @Message(id = Message.NONE, value = "Path to a CLI script to execute at boot time")
    String argCliScript();

    @Message(id = Message.NONE, value = "Path to a deployment (ear, jar, war) to install inside the hollow uber jar")
    String argDeployment();

    @Message(id = Message.NONE, value = "Path to server standalone XML config to be used by the uber jar")
    String argExternalConfig();

    @Message(id = Message.NONE, value = "Path to non existing directory in which the server will be installed. By default the server is installed in a tmp directory")
    String argServerDir();

    @Message(id = Message.NONE, value = "Do not delete the server installation dir when exiting")
    String argNoDelete();
}
