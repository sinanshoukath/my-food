/*
 * Created by sinan shoukath on 6/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.core.usecase

import com.sinan.core.repository.UserDataRepository

class DeleteMealById(val repository: UserDataRepository) {
  suspend operator fun invoke(id: String) = repository.deleteMealById(id)
}
