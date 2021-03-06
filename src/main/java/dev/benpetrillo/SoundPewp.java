/*
 * Copyright © 2022 Ben Petrillo, KingRainbow44. All rights reserved.
 *
 * Project licensed under the MIT License: https://www.mit.edu/~amini/LICENSE.md
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * All portions of this software are available for public use, provided that
 * credit is given to the original author(s).
 */

package dev.benpetrillo;

import dev.benpetrillo.utils.command.CommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public final class SoundPewp {

    private static JDA jda;

    public static void main(String[] args) {
        if (args.length < 1) return;
        JDABuilder builder = JDABuilder.create(Config.get("TOKEN"), EnumSet.allOf(GatewayIntent.class));
        builder.addEventListeners();
        builder.enableCache(CacheFlag.VOICE_STATE);
        try {
            jda = builder.build();
            CommandManager.registerCommands();
        } catch (LoginException ignored) { }
    }

    /**
     * Get the current JDA instance.
     * @return JDA
     */

    public static JDA getJda() {
        return jda;
    }
}
