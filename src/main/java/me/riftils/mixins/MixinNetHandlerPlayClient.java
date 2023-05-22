package me.riftils.mixins;

import me.riftils.events.PacketEvent;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetHandlerPlayClient.class)
public class MixinNetHandlerPlayClient {

    @Inject(method = "addToSendQueue", at = @At("HEAD"), cancellable = true)
    private void addToSendQueue(Packet<?> packet, CallbackInfo callbackInfo) {
        if(MinecraftForge.EVENT_BUS.post(new PacketEvent.Send(packet))) callbackInfo.cancel();
    }

}
