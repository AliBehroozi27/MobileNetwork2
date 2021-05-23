package com.example.domain.interactor

import com.example.domain.executor.PostExecutorThread
import com.example.domain.executor.UseCaseExecutorThread
import com.example.domain.interactor.base.SingleUseCase
import com.example.domain.model.Professor
import com.example.domain.repository.ProfessorRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetProfessorsUseCase @Inject constructor(
    private val professorRepository: ProfessorRepository,
    useCaseExecutorThread: UseCaseExecutorThread,
    postExecutorThread: PostExecutorThread
) :
    SingleUseCase<GetProfessorsUseCase.None, List<Professor>>(useCaseExecutorThread, postExecutorThread) {

    override fun buildSingle(params: None): Single<List<Professor>> {
        return professorRepository.getProfessors()
    }

    class None
}