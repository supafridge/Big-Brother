package gg.fridge.Big_Brother.Mixins;

import net.minecraft.client.multiplayer.resolver.AddressCheck;
import net.minecraft.client.multiplayer.resolver.ResolvedServerAddress;
import net.minecraft.client.multiplayer.resolver.ServerAddress;
import net.minecraft.client.multiplayer.resolver.ServerNameResolver;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import org.jspecify.annotations.NonNull;

@Mixin(ServerNameResolver.class)
public class ServerNameResolverMixin {
    @WrapOperation(
            method = "<clinit>",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/client/multiplayer/resolver/AddressCheck;createFromService()Lnet/minecraft/client/multiplayer/resolver/AddressCheck;")
    )
    private static AddressCheck BigBrother$unblock(Operation<AddressCheck> original) {
        return new AddressCheck() {
            @Override
            public boolean isAllowed(@NonNull ResolvedServerAddress address) { return true; }

            @Override
            public boolean isAllowed(@NonNull ServerAddress address) { return true; }
        };
    }
}
