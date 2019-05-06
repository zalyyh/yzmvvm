package com.zalyyh.mvvm.base


class GlobalConfigModule constructor(builder:Builder) {

    companion object{
        fun builder(): Builder {
            return Builder()
        }
        class Builder  constructor(){
            fun build(): GlobalConfigModule {
                return GlobalConfigModule(this)
            }
        }

    }


}