# YAWYE --You Are What You Eat

Ever felt that munching on a specific food in Minecraft should give you a little something extra? **You Are What You Eat (YAWYE)** is a simple, server-friendly Fabric mod that adds unique status effects when players consume various food items, making your culinary choices more impactful!

## Features

*   **Thematic Buffs:** Gain appropriate status effects after eating different foods.
    *   Eat an **Apple** for a quick burst of **Regeneration**.
    *   Devour **Cooked Beef** for temporary **Strength**.
    *   Snack on a **Cookie** for a **Speed** boost.
    *   Enjoy **Baked Potatoes** for powerful **Haste** while mining.
    *   ...and many more! (Discover them in-game!)
*   **Risk vs. Reward:**
    *   Eating **Raw Meats/Fish** now has a chance of inflicting negative effects like Nausea or Poison. *(The exact chances and effects may be subject to balancing).*
    *   Consuming **Rotten Flesh** provides a short surge of **Strength** but also comes with a side of **Poison** (in addition to vanilla's Hunger effect).
*   **Server-Side Friendly:** This mod's core logic runs on the server. **Clients do not need to install this mod to join a server running YAWYE and experience the effects.** Vanilla clients will correctly display and process all applied status effects.
*   **Lightweight:** Designed to be simple and have minimal performance impact.

## How It Works

YAWYE uses a Mixin to inject code into Minecraft's item usage logic. When a player finishes consuming a food item, the mod checks the item type and, if configured, applies the corresponding status effect(s) to the player.

Raw foods have a chance-based system for negative effects, while most cooked/prepared foods grant beneficial buffs.

## Effects (Reflecting your current code)

*   **Apple:** Regeneration I (5 seconds)
*   **Baked Potato:** Haste II (30 seconds)
*   **Beetroot:** Haste I (1 minute)
*   **Various Stews (Beetroot, Rabbit, Mushroom):** Saturation (instant boost)
*   **Golden Apple/Carrot/Enchanted Golden Apple:** Luck I (1 minute)
*   **Cooked Beef:** Strength I (30 seconds)
*   **Cooked Chicken:** Jump Boost I (30s) & Slow Falling (30s)
*   **Cooked Fish (Cod/Salmon):** Dolphin's Grace (30s) & Water Breathing (30s)
*   **Cookie:** Speed I (20 seconds)
*   **Rotten Flesh:** Strength I (10s) + Poison I (5s) + Vanilla Hunger
*   **Honey Bottle:** Speed I (15 seconds) (plus vanilla poison clear)
*   **Pumpkin Pie:** Jump Boost I (20 seconds)
*   **Raw Meats/Fish:** Chance of Nausea or Poison.

*(Note: Specific effects, durations, and chances are subject to change and balancing.)*

## Installation

**Requirements:**
*   Minecraft 1.21.5
*   Fabric Loader (latest recommended, e.g., 0.16.10+)
*   Fabric API (latest recommended)


*Mod by MLGMilk*
