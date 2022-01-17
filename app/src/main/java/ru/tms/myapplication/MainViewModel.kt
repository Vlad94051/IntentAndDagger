package ru.tms.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.tms.myapplication.data.IInteractor
import ru.tms.myapplication.data.Source
import ru.tms.myapplication.data.SourceResponse
import ru.tms.myapplication.data.model.StubUtil
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val interactor: IInteractor,
    stubUtil: StubUtil
) : ViewModel() {

    private val _sources = MutableLiveData<List<Source>>()
    val source: LiveData<List<Source>> get() = _sources

    init {
        loadSources()
        stubUtil.print()
    }

    private fun loadSources() {
        viewModelScope.launch {
          _sources.value = interactor.getSource().sources
        }
    }
}