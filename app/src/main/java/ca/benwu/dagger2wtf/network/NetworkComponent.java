package ca.benwu.dagger2wtf.network;

import dagger.Component;

@Component(modules = {NetworkModule.class})
public interface NetworkComponent {

    NetworkService getNetworkService();

}
