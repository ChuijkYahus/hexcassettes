package miyucomics.hexcassettes.inits

import miyucomics.hexcassettes.HexcassettesUtils
import net.minecraft.sound.SoundEvent
import net.minecraft.util.registry.Registry

object HexcassettesSounds {
	lateinit var CASSETTE_EJECT: SoundEvent
	lateinit var CASSETTE_FAIL: SoundEvent
	lateinit var CASSETTE_INSERT: SoundEvent
	lateinit var CASSETTE_LOOP: SoundEvent

	fun init() {
		CASSETTE_EJECT = register("cassette_eject")
		CASSETTE_FAIL = register("cassette_fail")
		CASSETTE_INSERT = register("cassette_insert")
		CASSETTE_LOOP = register("cassette_loop")
	}

	private fun register(name: String): SoundEvent {
		val id = HexcassettesUtils.id(name)
		val event = SoundEvent(id)
		Registry.register(Registry.SOUND_EVENT, id, event)
		return event
	}
}