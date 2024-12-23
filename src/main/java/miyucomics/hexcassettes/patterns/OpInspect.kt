package miyucomics.hexcassettes.patterns

import at.petrak.hexcasting.api.casting.castables.ConstMediaAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.iota.IotaType
import at.petrak.hexcasting.api.casting.iota.NullIota
import miyucomics.hexcassettes.HexcassettesAPI
import miyucomics.hexcassettes.HexcassettesUtils
import net.minecraft.server.network.ServerPlayerEntity

class OpInspect : ConstMediaAction {
	override val argc = 1
	override fun execute(args: List<Iota>, env: CastingEnvironment): List<Iota> {
		val caster = env.castingEntity
		if (caster != null && caster is ServerPlayerEntity) {
			val label = HexcassettesUtils.shortenLabel(args[0].display().string)
			val queuedHexes = HexcassettesAPI.getPlayerState(caster).queuedHexes
			if (queuedHexes.containsKey(label))
				return listOf(IotaType.deserialize(HexcassettesAPI.getPlayerState(caster).queuedHexes[label]!!.hex, env.world))
		}
		return listOf(NullIota())
	}
}