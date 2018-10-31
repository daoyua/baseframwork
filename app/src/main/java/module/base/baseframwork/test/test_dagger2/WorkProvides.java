package module.base.baseframwork.test.test_dagger2;

import dagger.Module;
import dagger.Provides;

@Module
public class WorkProvides {
    @Provides
   public Work provideWork(){
       return new Work(new WorkResponse());
   }

    @Provides
    public ItWork provideItWork(){
        return new ItWork();
    }

}
